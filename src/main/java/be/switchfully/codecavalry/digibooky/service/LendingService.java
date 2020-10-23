package be.switchfully.codecavalry.digibooky.service;

import be.switchfully.codecavalry.digibooky.business.entity.users.Member;
import be.switchfully.codecavalry.digibooky.business.repository.LendingRepository;
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
}
