package ssd.Entities.Publisher.Base.RESTapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ssd.Entities.Publisher.Base.Publisher;
import ssd.Entities.Publisher.Base.PublisherRepository;
import ssd.Entities.Publisher.Base.RESTapi.DTO.PublisherGetDTO;

import java.util.List;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    @Autowired
    private PublisherRepository publisherRepository;

    @GetMapping("/")
    public ResponseEntity<List<Publisher>> getAllPublishers() {
        List<Publisher> publishers = publisherRepository.findAll();
        return new ResponseEntity<>(publishers, HttpStatus.OK);
    }

    @GetMapping("/{publisherId}")
    public ResponseEntity<PublisherGetDTO> getPublisherById(@PathVariable Long publisherId) {
        return publisherRepository.findById(publisherId)
                .map(publisher -> new ResponseEntity<>(PublisherMapper.INSTANCE.convertEntityToPublisherGetDTO(publisher), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Publisher>> getPublishersByName(@PathVariable String name) {
        List<Publisher> publishers = publisherRepository.findByName(name);
        if (publishers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(publishers, HttpStatus.OK);
        }
    }

    @GetMapping("/popular/{amount}")
    public ResponseEntity<List<Publisher>> getPopularPublishers(@PathVariable int amount) {
        List<Publisher> publishers = publisherRepository.findAll();
        if (publishers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            int size = publishers.size();
            List<Publisher> popularPublishers = publishers.subList(Math.max(size - amount, 0), size);
            return new ResponseEntity<>(popularPublishers, HttpStatus.OK);
        }
    }
}
