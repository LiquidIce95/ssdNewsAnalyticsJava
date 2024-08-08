package ssd.Entities.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("/")
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @GetMapping("/{authorId}")
    public Author getAuthorById(@PathVariable Long authorId) {
        return authorRepository.findById(authorId).orElse(null);
    }

    @GetMapping("/name/{name}")
    public List<Author> getAuthorsByName(@PathVariable String name) {
        return authorRepository.findByName(name);
    }
}
