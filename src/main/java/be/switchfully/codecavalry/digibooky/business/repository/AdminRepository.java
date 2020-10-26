package be.switchfully.codecavalry.digibooky.business.repository;

import be.switchfully.codecavalry.digibooky.business.entity.users.Admin;
import be.switchfully.codecavalry.digibooky.exceptions.users.AdminAlreadyExistException;
import be.switchfully.codecavalry.digibooky.util.MailAddress;
import be.switchfully.codecavalry.digibooky.util.SocialSecurityNumber;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AdminRepository {

    private final Map<String, Admin> admins;

    public AdminRepository() {
        this.admins = new HashMap<>();
        addFirstAdmin();
    }

    public Admin save(Admin admin) {
        if (admins.containsValue(admin))
            throw new AdminAlreadyExistException((admin.getFirstname() + admin.getLastname()));
        admins.put(admin.getId(), admin);

        return admin;
    }

    public void addFirstAdmin(){
        Admin admin = new Admin(new SocialSecurityNumber("1342549-325-15"), "Adrie", "Admin", new MailAddress("adrie@admin.be"));
        admins.put(admin.getId(), admin);
    }

    public List<Admin> getAdmins() {
        return new ArrayList<>(admins.values());
    }
}
