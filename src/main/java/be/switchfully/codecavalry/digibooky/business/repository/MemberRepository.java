package be.switchfully.codecavalry.digibooky.business.repository;

import be.switchfully.codecavalry.digibooky.business.entity.users.Member;
import be.switchfully.codecavalry.digibooky.exceptions.users.MemberAlreadyExist;
import be.switchfully.codecavalry.digibooky.util.SocialSecurityNumber;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MemberRepository {

    private Map<SocialSecurityNumber, Member> members;

    public MemberRepository() {
        this.members = new HashMap<>();
    }

    public Member save(Member member){
        if(members.containsValue(member)) throw new MemberAlreadyExist(member.getFirstname() + member.getLastname());
         members.put(member.getSocialSecurityNumber(), member);

         return member;
    }

}
