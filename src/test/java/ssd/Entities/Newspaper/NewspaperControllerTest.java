package ssd.Entities.Newspaper;

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
public class NewspaperControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private NewspaperRepository newspaperRepository;

    @Autowired
    private NewspaperAnalyticsRepository newspaperAnalyticsRepository;

    private MockMvc mockMvc;

    private Newspaper newspaper;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();

        newspaperRepository.deleteAll();
        newspaperAnalyticsRepository.deleteAll();

        // Create and save necessary entities for testing
        NewspaperAnalytics newspaperAnalytics = new NewspaperAnalytics();
        newspaperAnalytics.setBias("Neutral");
        newspaperAnalytics.setViews(12000);
        newspaperAnalytics.setShares(450);
        newspaperAnalytics.setLikes(300);
        newspaperAnalytics.setEngagementRate(0.15);
        NewspaperAnalytics savedNewspaperAnalytics = newspaperAnalyticsRepository.saveAndFlush(newspaperAnalytics);

        newspaper = new Newspaper();
        newspaper.setName("Daily News");
        newspaper.setAnalytics(savedNewspaperAnalytics);
        newspaperRepository.saveAndFlush(newspaper);
    }

    @Test
    public void testGetAllNewspapers_emptyDatabase() throws Exception {
        newspaperRepository.deleteAll();

        this.mockMvc.perform(get("/newspapers/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    public void testGetAllNewspapers() throws Exception {
        this.mockMvc.perform(get("/newspapers/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Daily News"))
                .andExpect(jsonPath("$[0].analytics.bias").value("Neutral"))
                .andExpect(jsonPath("$[0].analytics.views").value(12000))
                .andExpect(jsonPath("$[0].analytics.shares").value(450))
                .andExpect(jsonPath("$[0].analytics.likes").value(300))
                .andExpect(jsonPath("$[0].analytics.engagementRate").value(0.15));
    }

    @Test
    public void testGetNewspaperById_notFound() throws Exception {
        this.mockMvc.perform(get("/newspapers/999")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGetNewspaperById() throws Exception {
        Long newspaperId = newspaper.getNewspaperId();

        this.mockMvc.perform(get("/newspapers/" + newspaperId)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Daily News"))
                .andExpect(jsonPath("$.analytics.bias").value("Neutral"))
                .andExpect(jsonPath("$.analytics.views").value(12000))
                .andExpect(jsonPath("$.analytics.shares").value(450))
                .andExpect(jsonPath("$.analytics.likes").value(300))
                .andExpect(jsonPath("$.analytics.engagementRate").value(0.15));
    }

    @Test
    public void testGetNewspapersByName_notFound() throws Exception {
        this.mockMvc.perform(get("/newspapers/name/Nonexistent Name")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGetNewspapersByName() throws Exception {
        this.mockMvc.perform(get("/newspapers/name/Daily News")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Daily News"))
                .andExpect(jsonPath("$[0].analytics.bias").value("Neutral"))
                .andExpect(jsonPath("$[0].analytics.views").value(12000))
                .andExpect(jsonPath("$[0].analytics.shares").value(450))
                .andExpect(jsonPath("$[0].analytics.likes").value(300))
                .andExpect(jsonPath("$[0].analytics.engagementRate").value(0.15));
    }

    @Test
    public void testGetPopularNewspapers() throws Exception {
        this.mockMvc.perform(get("/newspapers/popular/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Daily News"))
                .andExpect(jsonPath("$[0].analytics.bias").value("Neutral"))
                .andExpect(jsonPath("$[0].analytics.views").value(12000))
                .andExpect(jsonPath("$[0].analytics.shares").value(450))
                .andExpect(jsonPath("$[0].analytics.likes").value(300))
                .andExpect(jsonPath("$[0].analytics.engagementRate").value(0.15));
    }

    @Test
    public void testGetPopularNewspapers_noContent() throws Exception {
        newspaperRepository.deleteAll();

        this.mockMvc.perform(get("/newspapers/popular/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}
