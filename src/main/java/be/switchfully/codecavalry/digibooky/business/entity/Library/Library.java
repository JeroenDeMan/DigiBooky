package be.switchfully.codecavalry.digibooky.business.entity.Library;

import be.switchfully.codecavalry.digibooky.business.entity.users.Admin;
import org.springframework.stereotype.Component;

//@Component
public class Library {
    private final Admin admin;

    public Library(Admin admin) {
        this.admin = admin;
    }

    public Admin getAdmin() {
        return admin;
    }
}
