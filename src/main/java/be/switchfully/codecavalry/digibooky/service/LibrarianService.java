package be.switchfully.codecavalry.digibooky.service;

import be.switchfully.codecavalry.digibooky.business.entity.users.Librarian;
import be.switchfully.codecavalry.digibooky.business.repository.LibrarianRepository;
import be.switchfully.codecavalry.digibooky.service.dto.users.LibrarianDTO;
import be.switchfully.codecavalry.digibooky.service.dto.users.MemberDTO;
import be.switchfully.codecavalry.digibooky.service.mapper.LibrarianMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibrarianService {

    private final LibrarianRepository librarianRepository;
    private final LibrarianMapper librarianMapper;

    @Autowired
    public LibrarianService(LibrarianRepository librarianRepository, LibrarianMapper librarianMapper) {
        this.librarianRepository = librarianRepository;
        this.librarianMapper = librarianMapper;
    }

    public LibrarianDTO save(LibrarianDTO librarianDTO) {
        Librarian librarian = librarianRepository.save(librarianMapper.toEntity(librarianDTO));

        return librarianMapper.toDTO(librarian);
    }

    public List<LibrarianDTO> getAllLibrarians() {
        return librarianRepository.getLibrarians().stream()
                .map(librarianMapper::toDTO)
                .collect(Collectors.toList());
    }
}
