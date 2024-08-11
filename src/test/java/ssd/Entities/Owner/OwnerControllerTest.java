package ssd.Entities.Owner;

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
import ssd.Entities.Owner.Analytics.OwnerAnalytics;
import ssd.Entities.Owner.Analytics.OwnerAnalyticsRepository;
import ssd.Entities.Publisher.*;
import ssd.Entities.Publisher.Analytics.PublisherAnalyticsRepository;
import ssd.Entities.Topic.*;
import ssd.Entities.Topic.Analytics.TopicAnalyticsRepository;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class OwnerControllerTest {

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

        OwnerAnalytics ownerAnalytics = new OwnerAnalytics();
        ownerAnalytics.setBias("Neutral");
        ownerAnalytics.setViews(12000);
        ownerAnalytics.setShares(450);
        ownerAnalytics.setLikes(300);
        ownerAnalytics.setEngagementRate(0.15);
        OwnerAnalytics savedOwnerAnalytics = ownerAnalyticsRepository.saveAndFlush(ownerAnalytics);

        Owner owner = new Owner();
        owner.setName("John Smith");
        owner.setAnalytics(savedOwnerAnalytics);
        ownerRepository.saveAndFlush(owner);
    }

    @Test
    public void testGetAllOwners_emptyDatabase() {
        ownerRepository.deleteAll();

        ResponseEntity<Owner[]> response = restTemplate.getForEntity("/owners/", Owner[].class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEmpty();
    }

    @Test
    public void testGetAllOwners() {
        ResponseEntity<Owner[]> response = restTemplate.getForEntity("/owners/", Owner[].class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Owner[] owners = response.getBody();
        assertThat(owners).isNotNull();
        assertThat(owners.length).isGreaterThan(0);
        assertThat(owners[0].getName()).isEqualTo("John Smith");
        assertThat(owners[0].getAnalytics().getBias()).isEqualTo("Neutral");
        assertThat(owners[0].getAnalytics().getViews()).isEqualTo(12000);
        assertThat(owners[0].getAnalytics().getShares()).isEqualTo(450);
        assertThat(owners[0].getAnalytics().getLikes()).isEqualTo(300);
        assertThat(owners[0].getAnalytics().getEngagementRate()).isEqualTo(0.15);
    }

    @Test
    public void testGetOwnerById_notFound() {
        ResponseEntity<String> response = restTemplate.getForEntity("/owners/999", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void testGetOwnerById() {
        Owner owner = ownerRepository.findAll().get(0);
        Long ownerId = owner.getOwnerId();

        ResponseEntity<Owner> response = restTemplate.getForEntity("/owners/" + ownerId, Owner.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Owner retrievedOwner = response.getBody();
        assertThat(retrievedOwner).isNotNull();
        assertThat(retrievedOwner.getName()).isEqualTo("John Smith");
        assertThat(retrievedOwner.getAnalytics().getBias()).isEqualTo("Neutral");
        assertThat(retrievedOwner.getAnalytics().getViews()).isEqualTo(12000);
        assertThat(retrievedOwner.getAnalytics().getShares()).isEqualTo(450);
        assertThat(retrievedOwner.getAnalytics().getLikes()).isEqualTo(300);
        assertThat(retrievedOwner.getAnalytics().getEngagementRate()).isEqualTo(0.15);
    }

    @Test
    public void testGetOwnersByName_notFound() {
        ResponseEntity<String> response = restTemplate.getForEntity("/owners/name/Nonexistent Name", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void testGetOwnersByName() {
        ResponseEntity<Owner[]> response = restTemplate.getForEntity("/owners/name/John Smith", Owner[].class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Owner[] owners = response.getBody();
        assertThat(owners).isNotNull();
        assertThat(owners.length).isGreaterThan(0);
        assertThat(owners[0].getName()).isEqualTo("John Smith");
        assertThat(owners[0].getAnalytics().getBias()).isEqualTo("Neutral");
        assertThat(owners[0].getAnalytics().getViews()).isEqualTo(12000);
        assertThat(owners[0].getAnalytics().getShares()).isEqualTo(450);
        assertThat(owners[0].getAnalytics().getLikes()).isEqualTo(300);
        assertThat(owners[0].getAnalytics().getEngagementRate()).isEqualTo(0.15);
    }

    @Test
    public void testGetPopularOwners() {
        ResponseEntity<Owner[]> response = restTemplate.getForEntity("/owners/popular/1", Owner[].class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Owner[] owners = response.getBody();
        assertThat(owners).isNotNull();
        assertThat(owners.length).isEqualTo(1);
        assertThat(owners[0].getName()).isEqualTo("John Smith");
        assertThat(owners[0].getAnalytics().getBias()).isEqualTo("Neutral");
        assertThat(owners[0].getAnalytics().getViews()).isEqualTo(12000);
        assertThat(owners[0].getAnalytics().getShares()).isEqualTo(450);
        assertThat(owners[0].getAnalytics().getLikes()).isEqualTo(300);
        assertThat(owners[0].getAnalytics().getEngagementRate()).isEqualTo(0.15);
    }

    @Test
    public void testGetPopularOwners_noContent() {
        ownerRepository.deleteAll();

        ResponseEntity<String> response = restTemplate.getForEntity("/owners/popular/1", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }
}
