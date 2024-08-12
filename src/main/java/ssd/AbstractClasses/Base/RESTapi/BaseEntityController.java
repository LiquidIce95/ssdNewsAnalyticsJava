package ssd.AbstractClasses.Base.RESTapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ssd.AbstractClasses.Analytics.Analytics;
import ssd.AbstractClasses.Base.BaseEntity;
import ssd.AbstractClasses.Base.BaseEntityRepository;
import ssd.AbstractClasses.Base.RESTapi.DTO.BaseEntityGetDTO;
import ssd.AbstractClasses.Base.RESTapi.BaseEntityMapper;

import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseEntityController<
        T extends BaseEntity<? extends Analytics>,
        R extends BaseEntityRepository<T>,
        D extends BaseEntityGetDTO<? extends Analytics>,
        F extends BaseEntityMapper<T,D>> {

    @Autowired
    protected R repository;

    @Autowired
    protected F mapper;

    @Autowired
    public BaseEntityController(R repository, F mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @GetMapping("/")
    public ResponseEntity<List<D>> getAllEntities() {
        List<T> entities = repository.findAll();
        List<D> dtoList = entities.stream()
                .map(mapper::convertEntityToGetDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @GetMapping("/{entityId}")
    public ResponseEntity<D> getEntityById(@PathVariable Long entityId) {
        return repository.findById(entityId)
                .map(entity -> new ResponseEntity<>(mapper.convertEntityToGetDTO(entity), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<D>> getEntitiesByName(@PathVariable String name) {
        List<T> entities = repository.findByName(name);
        if (entities.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            List<D> dtoList = entities.stream()
                    .map(mapper::convertEntityToGetDTO)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(dtoList, HttpStatus.OK);
        }
    }

    @GetMapping("/popular/{amount}")
    public ResponseEntity<List<D>> getPopularEntities(@PathVariable int amount) {
        List<T> entities = repository.findAll();
        if (entities.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            int size = entities.size();
            List<T> popularEntities = entities.subList(Math.max(size - amount, 0), size);
            List<D> dtoList = popularEntities.stream()
                    .map(mapper::convertEntityToGetDTO)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(dtoList, HttpStatus.OK);
        }
    }
}
