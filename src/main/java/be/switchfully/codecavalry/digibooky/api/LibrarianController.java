package be.switchfully.codecavalry.digibooky.api;

import be.switchfully.codecavalry.digibooky.service.LibrarianService;
import be.switchfully.codecavalry.digibooky.service.dto.users.LibrarianDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/librarians")
public class LibrarianController {

    private final LibrarianService librarianService;

    @Autowired
    public LibrarianController(LibrarianService librarianService) {
        this.librarianService = librarianService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<LibrarianDTO> getAllMembers() {
        return librarianService.getAllLibrarians();
    }

    @PostMapping(path = "/admin", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public LibrarianDTO save(@RequestBody LibrarianDTO librarianDTO) {
        return librarianService.save(librarianDTO);
    }
}
