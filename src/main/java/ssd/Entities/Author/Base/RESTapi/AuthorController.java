package ssd.Entities.Author.Base.RESTapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ssd.Entities.Author.Base.Author;
import ssd.Entities.Author.Base.AuthorRepository;
import ssd.Entities.Author.Base.RESTapi.DTO.AuthorGetDTO;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("/")
    public ResponseEntity<List<Author>> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @GetMapping("/{authorId}")
    public ResponseEntity<AuthorGetDTO> getAuthorById(@PathVariable Long authorId) {
        return authorRepository.findById(authorId)
                .map(author -> new ResponseEntity<>(AuthorMapper.INSTANCE.convertEntityToAuthorGetDTO(author), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Author>> getAuthorsByName(@PathVariable String name) {
        List<Author> authors = authorRepository.findByName(name);
        if (authors.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(authors, HttpStatus.OK);
        }
    }

    @GetMapping("/popular/{amount}")
    public ResponseEntity<List<Author>> getPopularAuthors(@PathVariable int amount) {
        List<Author> authors = authorRepository.findAll();
        if (authors.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            int size = authors.size();
            List<Author> popularAuthors = authors.subList(Math.max(size - amount, 0), size);
            return new ResponseEntity<>(popularAuthors, HttpStatus.OK);
        }
    }
}
