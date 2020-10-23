package be.switchfully.codecavalry.digibooky.service;

import be.switchfully.codecavalry.digibooky.business.entity.users.Admin;
import be.switchfully.codecavalry.digibooky.business.repository.AdminRepository;
import be.switchfully.codecavalry.digibooky.service.dto.users.AdminDTO;
import be.switchfully.codecavalry.digibooky.service.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminService {

    private final AdminRepository adminRepository;
    private final AdminMapper adminMapper;

    @Autowired
    public AdminService(AdminRepository adminRepository, AdminMapper adminMapper) {
        this.adminRepository = adminRepository;
        this.adminMapper = adminMapper;
    }

    public AdminDTO save(AdminDTO adminDTO){
        Admin admin = adminRepository.save(adminMapper.toEntity(adminDTO));

        return adminMapper.toDTO(admin);
    }

    public List<AdminDTO> getAllAdmins() {
        return adminRepository.getAdmins().stream()
                .map(adminMapper::toDTO)
                .collect(Collectors.toList());
    }
}
