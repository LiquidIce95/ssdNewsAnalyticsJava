package ssd.Entities.Author;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ssd.Entities.Article.Analytics.ArticleAnalyticsRepository;
import ssd.Entities.Article.Base.ArticleRepository;
import ssd.Entities.Author.Analytics.AuthorAnalytics;
import ssd.Entities.Author.Analytics.AuthorAnalyticsRepository;
import ssd.Entities.Author.Base.Author;
import ssd.Entities.Author.Base.AuthorRepository;
import ssd.Entities.Newspaper.Analytics.NewspaperAnalyticsRepository;
import ssd.Entities.Newspaper.Base.NewspaperRepository;
import ssd.Entities.Owner.Analytics.OwnerAnalyticsRepository;
import ssd.Entities.Owner.Base.OwnerRepository;
import ssd.Entities.Publisher.Analytics.PublisherAnalyticsRepository;
import ssd.Entities.Publisher.Base.PublisherRepository;
import ssd.Entities.Topic.Analytics.TopicAnalyticsRepository;
import ssd.Entities.Topic.Base.TopicRepository;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AuthorControllerTest {

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

        AuthorAnalytics authorAnalytics = new AuthorAnalytics();
        authorAnalytics.setBias("Neutral");
        authorAnalytics.setViews(12000);
        authorAnalytics.setShares(450);
        authorAnalytics.setLikes(300);
        authorAnalytics.setEngagementRate(0.15);
        AuthorAnalytics savedAuthorAnalytics = authorAnalyticsRepository.saveAndFlush(authorAnalytics);

        Author author = new Author();
        author.setName("Jane Doe");
        author.setAnalytics(savedAuthorAnalytics);
        authorRepository.saveAndFlush(author);
    }

    @Test
    public void testGetAllAuthors_emptyDatabase() {
        authorRepository.deleteAll();

        ResponseEntity<Author[]> response = restTemplate.getForEntity("/authors/", Author[].class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEmpty();
    }

    @Test
    public void testGetAllAuthors() {
        ResponseEntity<Author[]> response = restTemplate.getForEntity("/authors/", Author[].class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Author[] authors = response.getBody();
        assertThat(authors).isNotNull();
        assertThat(authors.length).isGreaterThan(0);
        assertThat(authors[0].getName()).isEqualTo("Jane Doe");
        assertThat(authors[0].getAnalytics().getBias()).isEqualTo("Neutral");
        assertThat(authors[0].getAnalytics().getViews()).isEqualTo(12000);
        assertThat(authors[0].getAnalytics().getShares()).isEqualTo(450);
        assertThat(authors[0].getAnalytics().getLikes()).isEqualTo(300);
        assertThat(authors[0].getAnalytics().getEngagementRate()).isEqualTo(0.15);
    }

    @Test
    public void testGetAuthorById_notFound() {
        ResponseEntity<String> response = restTemplate.getForEntity("/authors/999", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void testGetAuthorById() {
        Author author = authorRepository.findAll().get(0);
        Long authorId = author.getId();

        ResponseEntity<Author> response = restTemplate.getForEntity("/authors/" + authorId, Author.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Author retrievedAuthor = response.getBody();
        assertThat(retrievedAuthor).isNotNull();
        assertThat(retrievedAuthor.getName()).isEqualTo("Jane Doe");
        assertThat(retrievedAuthor.getAnalytics().getBias()).isEqualTo("Neutral");
        assertThat(retrievedAuthor.getAnalytics().getViews()).isEqualTo(12000);
        assertThat(retrievedAuthor.getAnalytics().getShares()).isEqualTo(450);
        assertThat(retrievedAuthor.getAnalytics().getLikes()).isEqualTo(300);
        assertThat(retrievedAuthor.getAnalytics().getEngagementRate()).isEqualTo(0.15);
    }

    @Test
    public void testGetAuthorsByName_notFound() {
        ResponseEntity<String> response = restTemplate.getForEntity("/authors/name/Nonexistent Name", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void testGetAuthorsByName() {
        ResponseEntity<Author[]> response = restTemplate.getForEntity("/authors/name/Jane Doe", Author[].class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Author[] authors = response.getBody();
        assertThat(authors).isNotNull();
        assertThat(authors.length).isGreaterThan(0);
        assertThat(authors[0].getName()).isEqualTo("Jane Doe");
        assertThat(authors[0].getAnalytics().getBias()).isEqualTo("Neutral");
        assertThat(authors[0].getAnalytics().getViews()).isEqualTo(12000);
        assertThat(authors[0].getAnalytics().getShares()).isEqualTo(450);
        assertThat(authors[0].getAnalytics().getLikes()).isEqualTo(300);
        assertThat(authors[0].getAnalytics().getEngagementRate()).isEqualTo(0.15);
    }

    @Test
    public void testGetPopularAuthors() {
        ResponseEntity<Author[]> response = restTemplate.getForEntity("/authors/popular/1", Author[].class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Author[] authors = response.getBody();
        assertThat(authors).isNotNull();
        assertThat(authors.length).isEqualTo(1);
        assertThat(authors[0].getName()).isEqualTo("Jane Doe");
        assertThat(authors[0].getAnalytics().getBias()).isEqualTo("Neutral");
        assertThat(authors[0].getAnalytics().getViews()).isEqualTo(12000);
        assertThat(authors[0].getAnalytics().getShares()).isEqualTo(450);
        assertThat(authors[0].getAnalytics().getLikes()).isEqualTo(300);
        assertThat(authors[0].getAnalytics().getEngagementRate()).isEqualTo(0.15);
    }

    @Test
    public void testGetPopularAuthors_noContent() {
        authorRepository.deleteAll();

        ResponseEntity<String> response = restTemplate.getForEntity("/authors/popular/1", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }
}
