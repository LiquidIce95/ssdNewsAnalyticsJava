package ssd.Entities.Publisher;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class PublisherControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private PublisherAnalyticsRepository publisherAnalyticsRepository;

    private MockMvc mockMvc;

    private Publisher publisher;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();

        publisherRepository.deleteAll();
        publisherAnalyticsRepository.deleteAll();

        // Create and save necessary entities for testing
        PublisherAnalytics publisherAnalytics = new PublisherAnalytics();
        publisherAnalytics.setBias("Neutral");
        publisherAnalytics.setViews(12000);
        publisherAnalytics.setShares(450);
        publisherAnalytics.setLikes(300);
        publisherAnalytics.setEngagementRate(0.15);
        PublisherAnalytics savedPublisherAnalytics = publisherAnalyticsRepository.saveAndFlush(publisherAnalytics);

        publisher = new Publisher();
        publisher.setName("Global News Network");
        publisher.setAnalytics(savedPublisherAnalytics);
        publisherRepository.saveAndFlush(publisher);
    }

    @Test
    public void testGetAllPublishers_emptyDatabase() throws Exception {
        publisherRepository.deleteAll();

        this.mockMvc.perform(get("/publishers/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    public void testGetAllPublishers() throws Exception {
        this.mockMvc.perform(get("/publishers/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Global News Network"))
                .andExpect(jsonPath("$[0].analytics.bias").value("Neutral"))
                .andExpect(jsonPath("$[0].analytics.views").value(12000))
                .andExpect(jsonPath("$[0].analytics.shares").value(450))
                .andExpect(jsonPath("$[0].analytics.likes").value(300))
                .andExpect(jsonPath("$[0].analytics.engagementRate").value(0.15));
    }

    @Test
    public void testGetPublisherById_notFound() throws Exception {
        this.mockMvc.perform(get("/publishers/999")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGetPublisherById() throws Exception {
        Long publisherId = publisher.getPublisherId();

        this.mockMvc.perform(get("/publishers/" + publisherId)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Global News Network"))
                .andExpect(jsonPath("$.analytics.bias").value("Neutral"))
                .andExpect(jsonPath("$.analytics.views").value(12000))
                .andExpect(jsonPath("$.analytics.shares").value(450))
                .andExpect(jsonPath("$.analytics.likes").value(300))
                .andExpect(jsonPath("$.analytics.engagementRate").value(0.15));
    }

    @Test
    public void testGetPublishersByName_notFound() throws Exception {
        this.mockMvc.perform(get("/publishers/name/Nonexistent Name")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGetPublishersByName() throws Exception {
        this.mockMvc.perform(get("/publishers/name/Global News Network")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Global News Network"))
                .andExpect(jsonPath("$[0].analytics.bias").value("Neutral"))
                .andExpect(jsonPath("$[0].analytics.views").value(12000))
                .andExpect(jsonPath("$[0].analytics.shares").value(450))
                .andExpect(jsonPath("$[0].analytics.likes").value(300))
                .andExpect(jsonPath("$[0].analytics.engagementRate").value(0.15));
    }

    @Test
    public void testGetPopularPublishers() throws Exception {
        this.mockMvc.perform(get("/publishers/popular/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Global News Network"))
                .andExpect(jsonPath("$[0].analytics.bias").value("Neutral"))
                .andExpect(jsonPath("$[0].analytics.views").value(12000))
                .andExpect(jsonPath("$[0].analytics.shares").value(450))
                .andExpect(jsonPath("$[0].analytics.likes").value(300))
                .andExpect(jsonPath("$[0].analytics.engagementRate").value(0.15));
    }

    @Test
    public void testGetPopularPublishers_noContent() throws Exception {
        publisherRepository.deleteAll();

        this.mockMvc.perform(get("/publishers/popular/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}
