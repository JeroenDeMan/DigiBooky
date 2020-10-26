package be.switchfully.codecavalry.digibooky.api;

import be.switchfully.codecavalry.digibooky.service.LendingService;
import be.switchfully.codecavalry.digibooky.service.dto.LendingDTO;
import be.switchfully.codecavalry.digibooky.service.dto.users.LibrarianDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/lendings")
public class LendingController {
    private LendingService lendingService;

    @Autowired
    public LendingController(LendingService lendingService) {
        this.lendingService = lendingService;
    }

    @PostMapping(path = "/member", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public LendingDTO lendABook(@RequestBody LendingDTO lendingDTO) {
        return lendingService.lendABook(lendingDTO);
    }
}
