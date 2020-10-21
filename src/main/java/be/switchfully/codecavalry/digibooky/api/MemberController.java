package be.switchfully.codecavalry.digibooky.api;

import be.switchfully.codecavalry.digibooky.service.MemberService;
import be.switchfully.codecavalry.digibooky.service.dto.users.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/members")
public class MemberController {

    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public MemberDTO save(@RequestBody MemberDTO memberDTO){
        return memberService.save(memberDTO);
    }

}
