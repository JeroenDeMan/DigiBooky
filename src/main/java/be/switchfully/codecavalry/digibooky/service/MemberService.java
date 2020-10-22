package be.switchfully.codecavalry.digibooky.service;

import be.switchfully.codecavalry.digibooky.business.entity.users.Member;
import be.switchfully.codecavalry.digibooky.business.repository.MemberRepository;
import be.switchfully.codecavalry.digibooky.service.dto.users.MemberDTO;
import be.switchfully.codecavalry.digibooky.service.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    @Autowired
    public MemberService(MemberRepository memberRepository, MemberMapper memberMapper) {
        this.memberRepository = memberRepository;
        this.memberMapper = memberMapper;
    }

    public MemberDTO save(MemberDTO memberDTO){
        Member member = memberRepository.save(memberMapper.toEntity(memberDTO));

        return memberMapper.toDTO(member);
    }

    public List<MemberDTO> getAllMembers() {
        return memberRepository.getMembers().stream()
                .map(memberMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<MemberDTO> getAllMembersWithRestrictedINSS() {
        return memberRepository.getMembers().stream()
                .map(memberMapper::toRestrictedDTO)
                .collect(Collectors.toList());
    }
}
