package ssd.Entities.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @GetMapping("/")
    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    @GetMapping("/{topicId}")
    public Topic getTopicById(@PathVariable Long topicId) {
        return topicRepository.findById(topicId).orElse(null);
    }

    @GetMapping("/name/{name}")
    public List<Topic> getTopicsByName(@PathVariable String name) {
        return topicRepository.findByName(name);
    }
}
