package ssd.Entities.Topic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ssd.Entities.Article.*;
import ssd.Entities.Author.*;
import ssd.Entities.Newspaper.*;
import ssd.Entities.Owner.*;
import ssd.Entities.Publisher.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class TopicControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private NewspaperRepository newspaperRepository;

    @Autowired
    private ArticleAnalyticsRepository articleAnalyticsRepository;

    @Autowired
    private AuthorAnalyticsRepository authorAnalyticsRepository;

    @Autowired
    private PublisherAnalyticsRepository publisherAnalyticsRepository;

    @Autowired
    private TopicAnalyticsRepository topicAnalyticsRepository;

    @Autowired
    private OwnerAnalyticsRepository ownerAnalyticsRepository;

    @Autowired
    private NewspaperAnalyticsRepository newspaperAnalyticsRepository;

    @BeforeEach
    public void setup() {
        articleRepository.deleteAll();
        newspaperRepository.deleteAll();
        ownerRepository.deleteAll();
        topicRepository.deleteAll();
        publisherRepository.deleteAll();
        authorRepository.deleteAll();

        articleAnalyticsRepository.deleteAll();
        newspaperAnalyticsRepository.deleteAll();
        ownerAnalyticsRepository.deleteAll();
        topicAnalyticsRepository.deleteAll();
        publisherAnalyticsRepository.deleteAll();
        authorAnalyticsRepository.deleteAll();

        TopicAnalytics topicAnalytics = new TopicAnalytics();
        topicAnalytics.setBias("Neutral");
        topicAnalytics.setViews(12000);
        topicAnalytics.setShares(450);
        topicAnalytics.setLikes(300);
        topicAnalytics.setEngagementRate(0.15);
        TopicAnalytics savedTopicAnalytics = topicAnalyticsRepository.saveAndFlush(topicAnalytics);

        Topic topic = new Topic();
        topic.setName("Climate Change");
        topic.setAnalytics(savedTopicAnalytics);
        topicRepository.saveAndFlush(topic);
    }

    @Test
    public void testGetAllTopics_emptyDatabase() {
        topicRepository.deleteAll();

        ResponseEntity<Topic[]> response = restTemplate.getForEntity("/topics/", Topic[].class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEmpty();
    }

    @Test
    public void testGetAllTopics() {
        ResponseEntity<Topic[]> response = restTemplate.getForEntity("/topics/", Topic[].class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Topic[] topics = response.getBody();
        assertThat(topics).isNotNull();
        assertThat(topics.length).isGreaterThan(0);
        assertThat(topics[0].getName()).isEqualTo("Climate Change");
        assertThat(topics[0].getAnalytics().getBias()).isEqualTo("Neutral");
        assertThat(topics[0].getAnalytics().getViews()).isEqualTo(12000);
        assertThat(topics[0].getAnalytics().getShares()).isEqualTo(450);
        assertThat(topics[0].getAnalytics().getLikes()).isEqualTo(300);
        assertThat(topics[0].getAnalytics().getEngagementRate()).isEqualTo(0.15);
    }

    @Test
    public void testGetTopicById_notFound() {
        ResponseEntity<String> response = restTemplate.getForEntity("/topics/999", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void testGetTopicById() {
        Topic topic = topicRepository.findAll().get(0);
        Long topicId = topic.getTopicId();

        ResponseEntity<Topic> response = restTemplate.getForEntity("/topics/" + topicId, Topic.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Topic retrievedTopic = response.getBody();
        assertThat(retrievedTopic).isNotNull();
        assertThat(retrievedTopic.getName()).isEqualTo("Climate Change");
        assertThat(retrievedTopic.getAnalytics().getBias()).isEqualTo("Neutral");
        assertThat(retrievedTopic.getAnalytics().getViews()).isEqualTo(12000);
        assertThat(retrievedTopic.getAnalytics().getShares()).isEqualTo(450);
        assertThat(retrievedTopic.getAnalytics().getLikes()).isEqualTo(300);
        assertThat(retrievedTopic.getAnalytics().getEngagementRate()).isEqualTo(0.15);
    }

    @Test
    public void testGetTopicsByName_notFound() {
        ResponseEntity<String> response = restTemplate.getForEntity("/topics/name/Nonexistent Name", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void testGetTopicsByName() {
        ResponseEntity<Topic[]> response = restTemplate.getForEntity("/topics/name/Climate Change", Topic[].class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Topic[] topics = response.getBody();
        assertThat(topics).isNotNull();
        assertThat(topics.length).isGreaterThan(0);
        assertThat(topics[0].getName()).isEqualTo("Climate Change");
        assertThat(topics[0].getAnalytics().getBias()).isEqualTo("Neutral");
        assertThat(topics[0].getAnalytics().getViews()).isEqualTo(12000);
        assertThat(topics[0].getAnalytics().getShares()).isEqualTo(450);
        assertThat(topics[0].getAnalytics().getLikes()).isEqualTo(300);
        assertThat(topics[0].getAnalytics().getEngagementRate()).isEqualTo(0.15);
    }

    @Test
    public void testGetPopularTopics() {
        ResponseEntity<Topic[]> response = restTemplate.getForEntity("/topics/popular/1", Topic[].class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Topic[] topics = response.getBody();
        assertThat(topics).isNotNull();
        assertThat(topics.length).isEqualTo(1);
        assertThat(topics[0].getName()).isEqualTo("Climate Change");
        assertThat(topics[0].getAnalytics().getBias()).isEqualTo("Neutral");
        assertThat(topics[0].getAnalytics().getViews()).isEqualTo(12000);
        assertThat(topics[0].getAnalytics().getShares()).isEqualTo(450);
        assertThat(topics[0].getAnalytics().getLikes()).isEqualTo(300);
        assertThat(topics[0].getAnalytics().getEngagementRate()).isEqualTo(0.15);
    }

    @Test
    public void testGetPopularTopics_noContent() {
        topicRepository.deleteAll();

        ResponseEntity<String> response = restTemplate.getForEntity("/topics/popular/1", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }
}
