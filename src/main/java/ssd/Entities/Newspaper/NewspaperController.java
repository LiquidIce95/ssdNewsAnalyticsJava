package ssd.Entities.Newspaper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/newspapers")
public class NewspaperController {

    @Autowired
    private NewspaperRepository newspaperRepository;

    @GetMapping("/")
    public List<Newspaper> getAllNewspapers() {
        return newspaperRepository.findAll();
    }

    @GetMapping("/{newspaperId}")
    public Newspaper getNewspaperById(@PathVariable Long newspaperId) {
        return newspaperRepository.findById(newspaperId).orElse(null);
    }

    @GetMapping("/name/{name}")
    public List<Newspaper> getNewspapersByName(@PathVariable String name) {
        return newspaperRepository.findByName(name);
    }
}
