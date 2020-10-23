package be.switchfully.codecavalry.digibooky.service;

import be.switchfully.codecavalry.digibooky.business.entity.Library.Lending;
import be.switchfully.codecavalry.digibooky.business.entity.users.Member;
import be.switchfully.codecavalry.digibooky.business.repository.LendingRepository;
import be.switchfully.codecavalry.digibooky.service.dto.BookDTO;
import be.switchfully.codecavalry.digibooky.service.dto.LendingDTO;
import be.switchfully.codecavalry.digibooky.service.dto.users.MemberDTO;
import be.switchfully.codecavalry.digibooky.service.mapper.LendingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LendingService {

    private LendingRepository lendingRepository;
    private LendingMapper lendingMapper;
    private BookService bookService;
    private MemberService memberService;

    @Autowired
    public LendingService(LendingRepository lendingRepository, LendingMapper lendingMapper, BookService bookService, MemberService memberService) {
        this.lendingRepository = lendingRepository;
        this.lendingMapper = lendingMapper;
        this.bookService = bookService;
        this.memberService = memberService;
    }

    private LendingDTO addMemberName(LendingDTO lendingDTO) {
      //MemberDTO member = memberService.g
        return null;
    }

    private LendingDTO addBookTitle(LendingDTO lendingDTO) {
        BookDTO book = bookService.getBookDetailsById(lendingDTO.getBookId());
        lendingDTO.setBookTitle(book.getTitle());
        return lendingDTO;
    }

    public LendingDTO lendABook(LendingDTO lendingDTO) {
        Lending lending = lendingRepository.lendABook(lendingMapper.toEntity(lendingDTO));
        LendingDTO result = lendingMapper.toDTO(lending);
        result = addMemberName(result);
        result = addBookTitle(result);
        return result;
    }
}
