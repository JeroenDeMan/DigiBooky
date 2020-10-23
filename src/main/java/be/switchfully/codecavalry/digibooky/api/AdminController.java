package be.switchfully.codecavalry.digibooky.api;

import be.switchfully.codecavalry.digibooky.service.AdminService;
import be.switchfully.codecavalry.digibooky.service.LibrarianService;
import be.switchfully.codecavalry.digibooky.service.dto.users.AdminDTO;
import be.switchfully.codecavalry.digibooky.service.dto.users.LibrarianDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/admins")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<AdminDTO> getAllMembers() {
        return adminService.getAllAdmins();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public AdminDTO save(@RequestBody AdminDTO adminDTO) {
        return adminService.save(adminDTO);
    }
}
