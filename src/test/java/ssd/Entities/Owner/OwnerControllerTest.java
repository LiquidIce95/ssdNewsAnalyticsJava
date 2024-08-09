package ssd.Entities.Owner;

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
public class OwnerControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private OwnerAnalyticsRepository ownerAnalyticsRepository;

    private MockMvc mockMvc;

    private Owner owner;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();

        ownerRepository.deleteAll();
        ownerAnalyticsRepository.deleteAll();

        // Create and save necessary entities for testing
        OwnerAnalytics ownerAnalytics = new OwnerAnalytics();
        ownerAnalytics.setBias("Neutral");
        ownerAnalytics.setViews(12000);
        ownerAnalytics.setShares(450);
        ownerAnalytics.setLikes(300);
        ownerAnalytics.setEngagementRate(0.15);
        OwnerAnalytics savedOwnerAnalytics = ownerAnalyticsRepository.saveAndFlush(ownerAnalytics);

        owner = new Owner();
        owner.setName("John Smith");
        owner.setAnalytics(savedOwnerAnalytics);
        ownerRepository.saveAndFlush(owner);
    }

    @Test
    public void testGetAllOwners_emptyDatabase() throws Exception {
        ownerRepository.deleteAll();

        this.mockMvc.perform(get("/owners/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    public void testGetAllOwners() throws Exception {
        this.mockMvc.perform(get("/owners/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("John Smith"))
                .andExpect(jsonPath("$[0].analytics.bias").value("Neutral"))
                .andExpect(jsonPath("$[0].analytics.views").value(12000))
                .andExpect(jsonPath("$[0].analytics.shares").value(450))
                .andExpect(jsonPath("$[0].analytics.likes").value(300))
                .andExpect(jsonPath("$[0].analytics.engagementRate").value(0.15));
    }

    @Test
    public void testGetOwnerById_notFound() throws Exception {
        this.mockMvc.perform(get("/owners/999")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGetOwnerById() throws Exception {
        Long ownerId = owner.getOwnerId();

        this.mockMvc.perform(get("/owners/" + ownerId)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John Smith"))
                .andExpect(jsonPath("$.analytics.bias").value("Neutral"))
                .andExpect(jsonPath("$.analytics.views").value(12000))
                .andExpect(jsonPath("$.analytics.shares").value(450))
                .andExpect(jsonPath("$.analytics.likes").value(300))
                .andExpect(jsonPath("$.analytics.engagementRate").value(0.15));
    }

    @Test
    public void testGetOwnersByName_notFound() throws Exception {
        this.mockMvc.perform(get("/owners/name/Nonexistent Name")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGetOwnersByName() throws Exception {
        this.mockMvc.perform(get("/owners/name/John Smith")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("John Smith"))
                .andExpect(jsonPath("$[0].analytics.bias").value("Neutral"))
                .andExpect(jsonPath("$[0].analytics.views").value(12000))
                .andExpect(jsonPath("$[0].analytics.shares").value(450))
                .andExpect(jsonPath("$[0].analytics.likes").value(300))
                .andExpect(jsonPath("$[0].analytics.engagementRate").value(0.15));
    }

    @Test
    public void testGetPopularOwners() throws Exception {
        this.mockMvc.perform(get("/owners/popular/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("John Smith"))
                .andExpect(jsonPath("$[0].analytics.bias").value("Neutral"))
                .andExpect(jsonPath("$[0].analytics.views").value(12000))
                .andExpect(jsonPath("$[0].analytics.shares").value(450))
                .andExpect(jsonPath("$[0].analytics.likes").value(300))
                .andExpect(jsonPath("$[0].analytics.engagementRate").value(0.15));
    }

    @Test
    public void testGetPopularOwners_noContent() throws Exception {
        ownerRepository.deleteAll();

        this.mockMvc.perform(get("/owners/popular/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}
