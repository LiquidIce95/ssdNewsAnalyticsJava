package ssd.Entities.Topic;

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
public class TopicControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private TopicAnalyticsRepository topicAnalyticsRepository;

    private MockMvc mockMvc;

    private Topic topic;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();

        topicRepository.deleteAll();
        topicAnalyticsRepository.deleteAll();

        // Create and save necessary entities for testing
        TopicAnalytics topicAnalytics = new TopicAnalytics();
        topicAnalytics.setBias("Neutral");
        topicAnalytics.setViews(12000);
        topicAnalytics.setShares(450);
        topicAnalytics.setLikes(300);
        topicAnalytics.setEngagementRate(0.15);
        TopicAnalytics savedTopicAnalytics = topicAnalyticsRepository.saveAndFlush(topicAnalytics);

        topic = new Topic();
        topic.setName("Climate Change");
        topic.setAnalytics(savedTopicAnalytics);
        topicRepository.saveAndFlush(topic);
    }

    @Test
    public void testGetAllTopics_emptyDatabase() throws Exception {
        topicRepository.deleteAll();

        this.mockMvc.perform(get("/topics/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    public void testGetAllTopics() throws Exception {
        this.mockMvc.perform(get("/topics/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Climate Change"))
                .andExpect(jsonPath("$[0].analytics.bias").value("Neutral"))
                .andExpect(jsonPath("$[0].analytics.views").value(12000))
                .andExpect(jsonPath("$[0].analytics.shares").value(450))
                .andExpect(jsonPath("$[0].analytics.likes").value(300))
                .andExpect(jsonPath("$[0].analytics.engagementRate").value(0.15));
    }

    @Test
    public void testGetTopicById_notFound() throws Exception {
        this.mockMvc.perform(get("/topics/999")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGetTopicById() throws Exception {
        Long topicId = topic.getTopicId();

        this.mockMvc.perform(get("/topics/" + topicId)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Climate Change"))
                .andExpect(jsonPath("$.analytics.bias").value("Neutral"))
                .andExpect(jsonPath("$.analytics.views").value(12000))
                .andExpect(jsonPath("$.analytics.shares").value(450))
                .andExpect(jsonPath("$.analytics.likes").value(300))
                .andExpect(jsonPath("$.analytics.engagementRate").value(0.15));
    }

    @Test
    public void testGetTopicsByName_notFound() throws Exception {
        this.mockMvc.perform(get("/topics/name/Nonexistent Name")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGetTopicsByName() throws Exception {
        this.mockMvc.perform(get("/topics/name/Climate Change")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Climate Change"))
                .andExpect(jsonPath("$[0].analytics.bias").value("Neutral"))
                .andExpect(jsonPath("$[0].analytics.views").value(12000))
                .andExpect(jsonPath("$[0].analytics.shares").value(450))
                .andExpect(jsonPath("$[0].analytics.likes").value(300))
                .andExpect(jsonPath("$[0].analytics.engagementRate").value(0.15));
    }

    @Test
    public void testGetPopularTopics() throws Exception {
        this.mockMvc.perform(get("/topics/popular/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Climate Change"))
                .andExpect(jsonPath("$[0].analytics.bias").value("Neutral"))
                .andExpect(jsonPath("$[0].analytics.views").value(12000))
                .andExpect(jsonPath("$[0].analytics.shares").value(450))
                .andExpect(jsonPath("$[0].analytics.likes").value(300))
                .andExpect(jsonPath("$[0].analytics.engagementRate").value(0.15));
    }

    @Test
    public void testGetPopularTopics_noContent() throws Exception {
        topicRepository.deleteAll();

        this.mockMvc.perform(get("/topics/popular/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}
