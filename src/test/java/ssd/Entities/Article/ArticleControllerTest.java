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

import ssd.Entities.Author.*;
import ssd.Entities.Newspaper.*;
import ssd.Entities.Owner.*;
import ssd.Entities.Publisher.*;
import ssd.Entities.Topic.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

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

    private MockMvc mockMvc;

    private Article article;

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
        authorAnalyticsRepository.deleteAll();
        publisherAnalyticsRepository.deleteAll();
        topicAnalyticsRepository.deleteAll();
        ownerAnalyticsRepository.deleteAll();
        newspaperAnalyticsRepository.deleteAll();

        // Create and save necessary entities for testing
        AuthorAnalytics authorAnalytics = new AuthorAnalytics();
        authorAnalytics.setBias("Neutral");
        authorAnalytics.setViews(12000);
        authorAnalytics.setShares(450);
        authorAnalytics.setLikes(300);
        authorAnalytics.setEngagementRate(0.15);
        AuthorAnalytics savedAuthorAnalytics = authorAnalyticsRepository.saveAndFlush(authorAnalytics);

        Author author = new Author();
        author.setName("Jane Doe");
        author.setAge(30);
        author.setAnalytics(savedAuthorAnalytics);
        Author savedAuthor = authorRepository.saveAndFlush(author);

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
        Publisher savedPublisher = publisherRepository.saveAndFlush(publisher);

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
        Topic savedTopic = topicRepository.saveAndFlush(topic);

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
        Owner savedOwner = ownerRepository.saveAndFlush(owner);

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
        Newspaper savedNewspaper = newspaperRepository.saveAndFlush(newspaper);

        ArticleAnalytics articleAnalytics = new ArticleAnalytics();
        articleAnalytics.setBias("Neutral");
        articleAnalytics.setViews(12000);
        articleAnalytics.setShares(450);
        articleAnalytics.setLikes(300);
        articleAnalytics.setEngagementRate(0.15);
        ArticleAnalytics savedArticleAnalytics = articleAnalyticsRepository.saveAndFlush(articleAnalytics);

        article = new Article();
        article.setTitle("The Impact of Climate Change on Coastal Communities");
        article.setAuthor(savedAuthor);
        article.setPublisher(savedPublisher);
        article.setTopic(savedTopic);
        article.setOwner(savedOwner);
        article.setNewspaper(savedNewspaper);
        article.setContent("Coastal communities around the world are facing increasing threats from rising sea levels caused by climate change. This article explores the impact on these communities and the measures being taken to mitigate the damage.");
        article.setAnalytics(savedArticleAnalytics);
        articleRepository.saveAndFlush(article);
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
                .andExpect(jsonPath("$[0].title").value("The Impact of Climate Change on Coastal Communities"))
                .andExpect(jsonPath("$[0].author.name").value("Jane Doe"))
                .andExpect(jsonPath("$[0].publisher.name").value("Global News Network"))
                .andExpect(jsonPath("$[0].topic.name").value("Climate Change"))
                .andExpect(jsonPath("$[0].owner.name").value("John Smith"))
                .andExpect(jsonPath("$[0].newspaper.name").value("Daily News"))
                .andExpect(jsonPath("$[0].content").value("Coastal communities around the world are facing increasing threats from rising sea levels caused by climate change. This article explores the impact on these communities and the measures being taken to mitigate the damage."))
                .andExpect(jsonPath("$[0].analytics.bias").value("Neutral"))
                .andExpect(jsonPath("$[0].analytics.views").value(12000))
                .andExpect(jsonPath("$[0].analytics.shares").value(450))
                .andExpect(jsonPath("$[0].analytics.likes").value(300))
                .andExpect(jsonPath("$[0].analytics.engagementRate").value(0.15));
    }

    @Test
    public void testGetArticleById_notFound() throws Exception {
        this.mockMvc.perform(get("/articles/999")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGetArticleById() throws Exception {
        Long articleId = article.getArticleId();

        this.mockMvc.perform(get("/articles/" + articleId)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("The Impact of Climate Change on Coastal Communities"))
                .andExpect(jsonPath("$.author.name").value("Jane Doe"))
                .andExpect(jsonPath("$.publisher.name").value("Global News Network"))
                .andExpect(jsonPath("$.topic.name").value("Climate Change"))
                .andExpect(jsonPath("$.owner.name").value("John Smith"))
                .andExpect(jsonPath("$.newspaper.name").value("Daily News"))
                .andExpect(jsonPath("$.content").value("Coastal communities around the world are facing increasing threats from rising sea levels caused by climate change. This article explores the impact on these communities and the measures being taken to mitigate the damage."))
                .andExpect(jsonPath("$.analytics.bias").value("Neutral"))
                .andExpect(jsonPath("$.analytics.views").value(12000))
                .andExpect(jsonPath("$.analytics.shares").value(450))
                .andExpect(jsonPath("$.analytics.likes").value(300))
                .andExpect(jsonPath("$.analytics.engagementRate").value(0.15));
    }

    @Test
    public void testGetArticlesByTitle_notFound() throws Exception {
        this.mockMvc.perform(get("/articles/title/Nonexistent Title")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGetArticlesByTitle() throws Exception {
        this.mockMvc.perform(get("/articles/title/The Impact of Climate Change on Coastal Communities")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("The Impact of Climate Change on Coastal Communities"))
                .andExpect(jsonPath("$[0].author.name").value("Jane Doe"))
                .andExpect(jsonPath("$[0].publisher.name").value("Global News Network"))
                .andExpect(jsonPath("$[0].topic.name").value("Climate Change"))
                .andExpect(jsonPath("$[0].owner.name").value("John Smith"))
                .andExpect(jsonPath("$[0].newspaper.name").value("Daily News"))
                .andExpect(jsonPath("$[0].content").value("Coastal communities around the world are facing increasing threats from rising sea levels caused by climate change. This article explores the impact on these communities and the measures being taken to mitigate the damage."))
                .andExpect(jsonPath("$[0].analytics.bias").value("Neutral"))
                .andExpect(jsonPath("$[0].analytics.views").value(12000))
                .andExpect(jsonPath("$[0].analytics.shares").value(450))
                .andExpect(jsonPath("$[0].analytics.likes").value(300))
                .andExpect(jsonPath("$[0].analytics.engagementRate").value(0.15));
    }

    @Test
    public void testGetPopularArticles() throws Exception {
        this.mockMvc.perform(get("/articles/popular/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("The Impact of Climate Change on Coastal Communities"))
                .andExpect(jsonPath("$[0].author.name").value("Jane Doe"))
                .andExpect(jsonPath("$[0].publisher.name").value("Global News Network"))
                .andExpect(jsonPath("$[0].topic.name").value("Climate Change"))
                .andExpect(jsonPath("$[0].owner.name").value("John Smith"))
                .andExpect(jsonPath("$[0].newspaper.name").value("Daily News"))
                .andExpect(jsonPath("$[0].content").value("Coastal communities around the world are facing increasing threats from rising sea levels caused by climate change. This article explores the impact on these communities and the measures being taken to mitigate the damage."))
                .andExpect(jsonPath("$[0].analytics.bias").value("Neutral"))
                .andExpect(jsonPath("$[0].analytics.views").value(12000))
                .andExpect(jsonPath("$[0].analytics.shares").value(450))
                .andExpect(jsonPath("$[0].analytics.likes").value(300))
                .andExpect(jsonPath("$[0].analytics.engagementRate").value(0.15));
    }

    @Test
    public void testGetPopularArticles_noContent() throws Exception {
        articleRepository.deleteAll();

        this.mockMvc.perform(get("/articles/popular/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}
