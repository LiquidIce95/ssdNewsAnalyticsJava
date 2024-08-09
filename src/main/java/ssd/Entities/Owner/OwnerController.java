package ssd.Entities.Owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private OwnerRepository ownerRepository;

    @GetMapping("/")
    public ResponseEntity<List<Owner>> getAllOwners() {
        List<Owner> owners = ownerRepository.findAll();
        return new ResponseEntity<>(owners, HttpStatus.OK);
    }

    @GetMapping("/{ownerId}")
    public ResponseEntity<OwnerGetDTO> getOwnerById(@PathVariable Long ownerId) {
        return ownerRepository.findById(ownerId)
                .map(owner -> new ResponseEntity<>(OwnerMapper.INSTANCE.convertEntityToOwnerGetDTO(owner), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Owner>> getOwnersByName(@PathVariable String name) {
        List<Owner> owners = ownerRepository.findByName(name);
        if (owners.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(owners, HttpStatus.OK);
        }
    }

    @GetMapping("/popular/{amount}")
    public ResponseEntity<List<Owner>> getPopularOwners(@PathVariable int amount) {
        List<Owner> owners = ownerRepository.findAll();
        if (owners.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            int size = owners.size();
            List<Owner> popularOwners = owners.subList(Math.max(size - amount, 0), size);
            return new ResponseEntity<>(popularOwners, HttpStatus.OK);
        }
    }
}
