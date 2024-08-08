package ssd.Entities.Article;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ArticleControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

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

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();

        articleRepository.deleteAll();
        authorRepository.deleteAll();
        publisherRepository.deleteAll();
        topicRepository.deleteAll();
        ownerRepository.deleteAll();
        newspaperRepository.deleteAll();
        articleAnalyticsRepository.deleteAll();

        Author author = new Author();
        author.setName("Jane Doe");
        author.setAge(30);
        Author savedAuthor = authorRepository.save(author);

        Publisher publisher = new Publisher();
        publisher.setName("Global News Network");
        Publisher savedPublisher = publisherRepository.save(publisher);

        Topic topic = new Topic();
        topic.setName("Climate Change");
        Topic savedTopic = topicRepository.save(topic);

        Owner owner = new Owner();
        owner.setName("John Smith");
        Owner savedOwner = ownerRepository.save(owner);

        Newspaper newspaper = new Newspaper();
        newspaper.setName("Daily News");
        Newspaper savedNewspaper = newspaperRepository.save(newspaper);

        ArticleAnalytics analytics = new ArticleAnalytics();
        analytics.setBias("Neutral");
        analytics.setViews(12000);
        analytics.setShares(450);
        analytics.setLikes(300);
        analytics.setEngagementRate(0.15);
        ArticleAnalytics savedAnalytics = articleAnalyticsRepository.save(analytics);

        Article article = new Article();
        article.setTitle("The Impact of Climate Change on Coastal Communities");
        article.setAuthor(savedAuthor);
        article.setPublisher(savedPublisher);
        article.setTopic(savedTopic);
        article.setOwner(savedOwner);
        article.setNewspaper(savedNewspaper);
        article.setContent("Coastal communities around the world are facing increasing threats from rising sea levels caused by climate change. This article explores the impact on these communities and the measures being taken to mitigate the damage.");
        article.setAnalytics(savedAnalytics);
        articleRepository.save(article);
    }

    @Test
    public void testGetAllArticles_emptyDatabase() throws Exception {
        articleRepository.deleteAll();

        this.mockMvc.perform(get("/articles/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    public void testGetAllArticles() throws Exception {
        this.mockMvc.perform(get("/articles/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"title\":\"The Impact of Climate Change on Coastal Communities\"}]"));
    }

    @Test
    public void testGetArticleById_notFound() throws Exception {
        this.mockMvc.perform(get("/articles/999")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("null"));
    }

    @Test
    public void testGetArticleById() throws Exception {
        Article article = articleRepository.findByTitle("The Impact of Climate Change on Coastal Communities").get(0);
        Long articleId = article.getArticleId();

        this.mockMvc.perform(get("/articles/" + articleId)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"title\":\"The Impact of Climate Change on Coastal Communities\"}"));
    }

    @Test
    public void testGetArticlesByTitle_notFound() throws Exception {
        this.mockMvc.perform(get("/articles/title/Nonexistent Title")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    public void testGetArticlesByTitle() throws Exception {
        this.mockMvc.perform(get("/articles/title/The Impact of Climate Change on Coastal Communities")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"title\":\"The Impact of Climate Change on Coastal Communities\"}]"));
    }
}
