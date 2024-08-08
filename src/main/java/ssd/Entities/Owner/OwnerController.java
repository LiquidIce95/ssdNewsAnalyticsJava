package ssd.Entities.Owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private OwnerRepository ownerRepository;

    @GetMapping("/")
    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    @GetMapping("/{ownerId}")
    public Owner getOwnerById(@PathVariable Long ownerId) {
        return ownerRepository.findById(ownerId).orElse(null);
    }

    @GetMapping("/name/{name}")
    public List<Owner> getOwnersByName(@PathVariable String name) {
        return ownerRepository.findByName(name);
    }
}
