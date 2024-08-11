package ssd.Entities.Newspaper.RESTapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ssd.Entities.Newspaper.Newspaper;
import ssd.Entities.Newspaper.NewspaperRepository;
import ssd.Entities.Newspaper.RESTapi.DTO.NewspaperGetDTO;

import java.util.List;

@RestController
@RequestMapping("/newspapers")
public class NewspaperController {

    @Autowired
    private NewspaperRepository newspaperRepository;

    @GetMapping("/")
    public ResponseEntity<List<Newspaper>> getAllNewspapers() {
        List<Newspaper> newspapers = newspaperRepository.findAll();
        return new ResponseEntity<>(newspapers, HttpStatus.OK);
    }

    @GetMapping("/{newspaperId}")
    public ResponseEntity<NewspaperGetDTO> getNewspaperById(@PathVariable Long newspaperId) {
        return newspaperRepository.findById(newspaperId)
                .map(newspaper -> new ResponseEntity<>(NewspaperMapper.INSTANCE.convertEntityToNewspaperGetDTO(newspaper), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Newspaper>> getNewspapersByName(@PathVariable String name) {
        List<Newspaper> newspapers = newspaperRepository.findByName(name);
        if (newspapers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(newspapers, HttpStatus.OK);
        }
    }

    @GetMapping("/popular/{amount}")
    public ResponseEntity<List<Newspaper>> getPopularNewspapers(@PathVariable int amount) {
        List<Newspaper> newspapers = newspaperRepository.findAll();
        if (newspapers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            int size = newspapers.size();
            List<Newspaper> popularNewspapers = newspapers.subList(Math.max(size - amount, 0), size);
            return new ResponseEntity<>(popularNewspapers, HttpStatus.OK);
        }
    }
}
