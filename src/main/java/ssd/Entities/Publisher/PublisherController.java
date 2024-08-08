package ssd.Entities.Publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    @Autowired
    private PublisherRepository publisherRepository;

    @GetMapping("/")
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    @GetMapping("/{publisherId}")
    public Publisher getPublisherById(@PathVariable Long publisherId) {
        return publisherRepository.findById(publisherId).orElse(null);
    }

    @GetMapping("/name/{name}")
    public List<Publisher> getPublishersByName(@PathVariable String name) {
        return publisherRepository.findByName(name);
    }
}
