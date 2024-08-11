package ssd.Entities.Publisher;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ssd.Entities.Article.*;
import ssd.Entities.Article.Analytics.ArticleAnalyticsRepository;
import ssd.Entities.Author.*;
import ssd.Entities.Author.Analytics.AuthorAnalyticsRepository;
import ssd.Entities.Newspaper.*;
import ssd.Entities.Newspaper.Analytics.NewspaperAnalyticsRepository;
import ssd.Entities.Owner.*;
import ssd.Entities.Owner.Analytics.OwnerAnalyticsRepository;
import ssd.Entities.Publisher.Analytics.PublisherAnalytics;
import ssd.Entities.Publisher.Analytics.PublisherAnalyticsRepository;
import ssd.Entities.Topic.*;
import ssd.Entities.Topic.Analytics.TopicAnalyticsRepository;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class PublisherControllerTest {

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

        PublisherAnalytics publisherAnalytics = new PublisherAnalytics();
        publisherAnalytics.setBias("Neutral");
        publisherAnalytics.setViews(12000);
        publisherAnalytics.setShares(450);
        publisherAnalytics.setLikes(300);
        publisherAnalytics.setEngagementRate(0.15);
        PublisherAnalytics savedPublisherAnalytics = publisherAnalyticsRepository.saveAndFlush(publisherAnalytics);

        Publisher publisher = new Publisher();
        publisher.setName("Global News Network");
        publisher.setAnalytics(savedPublisherAnalytics);
        publisherRepository.saveAndFlush(publisher);
    }

    @Test
    public void testGetAllPublishers_emptyDatabase() {
        publisherRepository.deleteAll();

        ResponseEntity<Publisher[]> response = restTemplate.getForEntity("/publishers/", Publisher[].class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEmpty();
    }

    @Test
    public void testGetAllPublishers() {
        ResponseEntity<Publisher[]> response = restTemplate.getForEntity("/publishers/", Publisher[].class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Publisher[] publishers = response.getBody();
        assertThat(publishers).isNotNull();
        assertThat(publishers.length).isGreaterThan(0);
        assertThat(publishers[0].getName()).isEqualTo("Global News Network");
        assertThat(publishers[0].getAnalytics().getBias()).isEqualTo("Neutral");
        assertThat(publishers[0].getAnalytics().getViews()).isEqualTo(12000);
        assertThat(publishers[0].getAnalytics().getShares()).isEqualTo(450);
        assertThat(publishers[0].getAnalytics().getLikes()).isEqualTo(300);
        assertThat(publishers[0].getAnalytics().getEngagementRate()).isEqualTo(0.15);
    }

    @Test
    public void testGetPublisherById_notFound() {
        ResponseEntity<String> response = restTemplate.getForEntity("/publishers/999", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void testGetPublisherById() {
        Publisher publisher = publisherRepository.findAll().get(0);
        Long publisherId = publisher.getPublisherId();

        ResponseEntity<Publisher> response = restTemplate.getForEntity("/publishers/" + publisherId, Publisher.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Publisher retrievedPublisher = response.getBody();
        assertThat(retrievedPublisher).isNotNull();
        assertThat(retrievedPublisher.getName()).isEqualTo("Global News Network");
        assertThat(retrievedPublisher.getAnalytics().getBias()).isEqualTo("Neutral");
        assertThat(retrievedPublisher.getAnalytics().getViews()).isEqualTo(12000);
        assertThat(retrievedPublisher.getAnalytics().getShares()).isEqualTo(450);
        assertThat(retrievedPublisher.getAnalytics().getLikes()).isEqualTo(300);
        assertThat(retrievedPublisher.getAnalytics().getEngagementRate()).isEqualTo(0.15);
    }

    @Test
    public void testGetPublishersByName_notFound() {
        ResponseEntity<String> response = restTemplate.getForEntity("/publishers/name/Nonexistent Name", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void testGetPublishersByName() {
        ResponseEntity<Publisher[]> response = restTemplate.getForEntity("/publishers/name/Global News Network", Publisher[].class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Publisher[] publishers = response.getBody();
        assertThat(publishers).isNotNull();
        assertThat(publishers.length).isGreaterThan(0);
        assertThat(publishers[0].getName()).isEqualTo("Global News Network");
        assertThat(publishers[0].getAnalytics().getBias()).isEqualTo("Neutral");
        assertThat(publishers[0].getAnalytics().getViews()).isEqualTo(12000);
        assertThat(publishers[0].getAnalytics().getShares()).isEqualTo(450);
        assertThat(publishers[0].getAnalytics().getLikes()).isEqualTo(300);
        assertThat(publishers[0].getAnalytics().getEngagementRate()).isEqualTo(0.15);
    }

    @Test
    public void testGetPopularPublishers() {
        ResponseEntity<Publisher[]> response = restTemplate.getForEntity("/publishers/popular/1", Publisher[].class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Publisher[] publishers = response.getBody();
        assertThat(publishers).isNotNull();
        assertThat(publishers.length).isEqualTo(1);
        assertThat(publishers[0].getName()).isEqualTo("Global News Network");
        assertThat(publishers[0].getAnalytics().getBias()).isEqualTo("Neutral");
        assertThat(publishers[0].getAnalytics().getViews()).isEqualTo(12000);
        assertThat(publishers[0].getAnalytics().getShares()).isEqualTo(450);
        assertThat(publishers[0].getAnalytics().getLikes()).isEqualTo(300);
        assertThat(publishers[0].getAnalytics().getEngagementRate()).isEqualTo(0.15);
    }

    @Test
    public void testGetPopularPublishers_noContent() {
        publisherRepository.deleteAll();

        ResponseEntity<String> response = restTemplate.getForEntity("/publishers/popular/1", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }
}
