package ssd.Entities.Newspaper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ssd.Entities.Article.Analytics.ArticleAnalyticsRepository;
import ssd.Entities.Article.Base.ArticleRepository;
import ssd.Entities.Author.Analytics.AuthorAnalyticsRepository;
import ssd.Entities.Author.Base.AuthorRepository;
import ssd.Entities.Newspaper.Analytics.NewspaperAnalytics;
import ssd.Entities.Newspaper.Analytics.NewspaperAnalyticsRepository;
import ssd.Entities.Newspaper.Base.Newspaper;
import ssd.Entities.Newspaper.Base.NewspaperRepository;
import ssd.Entities.Owner.Analytics.OwnerAnalyticsRepository;
import ssd.Entities.Owner.Base.OwnerRepository;
import ssd.Entities.Publisher.Analytics.PublisherAnalyticsRepository;
import ssd.Entities.Publisher.Base.PublisherRepository;
import ssd.Entities.Topic.Analytics.TopicAnalyticsRepository;
import ssd.Entities.Topic.Base.TopicRepository;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class NewspaperControllerTest {

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

        NewspaperAnalytics newspaperAnalytics = new NewspaperAnalytics();
        newspaperAnalytics.setBias("Neutral");
        newspaperAnalytics.setViews(12000);
        newspaperAnalytics.setShares(450);
        newspaperAnalytics.setLikes(300);
        newspaperAnalytics.setEngagementRate(0.15);
        NewspaperAnalytics savedNewspaperAnalytics = newspaperAnalyticsRepository.saveAndFlush(newspaperAnalytics);

        Newspaper newspaper = new Newspaper();
        newspaper.setName("Daily News");
        newspaper.setAnalytics(savedNewspaperAnalytics);
        newspaperRepository.saveAndFlush(newspaper);
    }

    @Test
    public void testGetAllNewspapers_emptyDatabase() {
        newspaperRepository.deleteAll();

        ResponseEntity<Newspaper[]> response = restTemplate.getForEntity("/newspapers/", Newspaper[].class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEmpty();
    }

    @Test
    public void testGetAllNewspapers() {
        ResponseEntity<Newspaper[]> response = restTemplate.getForEntity("/newspapers/", Newspaper[].class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Newspaper[] newspapers = response.getBody();
        assertThat(newspapers).isNotNull();
        assertThat(newspapers.length).isGreaterThan(0);
        assertThat(newspapers[0].getName()).isEqualTo("Daily News");
        assertThat(newspapers[0].getAnalytics().getBias()).isEqualTo("Neutral");
        assertThat(newspapers[0].getAnalytics().getViews()).isEqualTo(12000);
        assertThat(newspapers[0].getAnalytics().getShares()).isEqualTo(450);
        assertThat(newspapers[0].getAnalytics().getLikes()).isEqualTo(300);
        assertThat(newspapers[0].getAnalytics().getEngagementRate()).isEqualTo(0.15);
    }

    @Test
    public void testGetNewspaperById_notFound() {
        ResponseEntity<String> response = restTemplate.getForEntity("/newspapers/999", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void testGetNewspaperById() {
        Newspaper newspaper = newspaperRepository.findAll().get(0);
        Long newspaperId = newspaper.getId();

        ResponseEntity<Newspaper> response = restTemplate.getForEntity("/newspapers/" + newspaperId, Newspaper.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Newspaper retrievedNewspaper = response.getBody();
        assertThat(retrievedNewspaper).isNotNull();
        assertThat(retrievedNewspaper.getName()).isEqualTo("Daily News");
        assertThat(retrievedNewspaper.getAnalytics().getBias()).isEqualTo("Neutral");
        assertThat(retrievedNewspaper.getAnalytics().getViews()).isEqualTo(12000);
        assertThat(retrievedNewspaper.getAnalytics().getShares()).isEqualTo(450);
        assertThat(retrievedNewspaper.getAnalytics().getLikes()).isEqualTo(300);
        assertThat(retrievedNewspaper.getAnalytics().getEngagementRate()).isEqualTo(0.15);
    }

    @Test
    public void testGetNewspapersByName_notFound() {
        ResponseEntity<String> response = restTemplate.getForEntity("/newspapers/name/Nonexistent Name", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void testGetNewspapersByName() {
        ResponseEntity<Newspaper[]> response = restTemplate.getForEntity("/newspapers/name/Daily News", Newspaper[].class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Newspaper[] newspapers = response.getBody();
        assertThat(newspapers).isNotNull();
        assertThat(newspapers.length).isGreaterThan(0);
        assertThat(newspapers[0].getName()).isEqualTo("Daily News");
        assertThat(newspapers[0].getAnalytics().getBias()).isEqualTo("Neutral");
        assertThat(newspapers[0].getAnalytics().getViews()).isEqualTo(12000);
        assertThat(newspapers[0].getAnalytics().getShares()).isEqualTo(450);
        assertThat(newspapers[0].getAnalytics().getLikes()).isEqualTo(300);
        assertThat(newspapers[0].getAnalytics().getEngagementRate()).isEqualTo(0.15);
    }

    @Test
    public void testGetPopularNewspapers() {
        ResponseEntity<Newspaper[]> response = restTemplate.getForEntity("/newspapers/popular/1", Newspaper[].class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Newspaper[] newspapers = response.getBody();
        assertThat(newspapers).isNotNull();
        assertThat(newspapers.length).isEqualTo(1);
        assertThat(newspapers[0].getName()).isEqualTo("Daily News");
        assertThat(newspapers[0].getAnalytics().getBias()).isEqualTo("Neutral");
        assertThat(newspapers[0].getAnalytics().getViews()).isEqualTo(12000);
        assertThat(newspapers[0].getAnalytics().getShares()).isEqualTo(450);
        assertThat(newspapers[0].getAnalytics().getLikes()).isEqualTo(300);
        assertThat(newspapers[0].getAnalytics().getEngagementRate()).isEqualTo(0.15);
    }

    @Test
    public void testGetPopularNewspapers_noContent() {
        newspaperRepository.deleteAll();

        ResponseEntity<String> response = restTemplate.getForEntity("/newspapers/popular/1", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }
}
