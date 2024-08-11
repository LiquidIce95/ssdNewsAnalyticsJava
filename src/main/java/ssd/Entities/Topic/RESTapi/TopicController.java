package ssd.Entities.Topic.RESTapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ssd.Entities.Topic.Topic;
import ssd.Entities.Topic.TopicRepository;
import ssd.Entities.Topic.RESTapi.DTO.TopicGetDTO;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @GetMapping("/")
    public ResponseEntity<List<Topic>> getAllTopics() {
        List<Topic> topics = topicRepository.findAll();
        return new ResponseEntity<>(topics, HttpStatus.OK);
    }

    @GetMapping("/{topicId}")
    public ResponseEntity<TopicGetDTO> getTopicById(@PathVariable Long topicId) {
        return topicRepository.findById(topicId)
                .map(topic -> new ResponseEntity<>(TopicMapper.INSTANCE.convertEntityToTopicGetDTO(topic), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Topic>> getTopicsByName(@PathVariable String name) {
        List<Topic> topics = topicRepository.findByName(name);
        if (topics.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(topics, HttpStatus.OK);
        }
    }

    @GetMapping("/popular/{amount}")
    public ResponseEntity<List<Topic>> getPopularTopics(@PathVariable int amount) {
        List<Topic> topics = topicRepository.findAll();
        if (topics.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            int size = topics.size();
            List<Topic> popularTopics = topics.subList(Math.max(size - amount, 0), size);
            return new ResponseEntity<>(popularTopics, HttpStatus.OK);
        }
    }
}
