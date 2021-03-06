package be.switchfully.codecavalry.digibooky.business.repository;

import be.switchfully.codecavalry.digibooky.business.entity.users.Member;
import be.switchfully.codecavalry.digibooky.exceptions.users.MemberAlreadyExistsException;
import be.switchfully.codecavalry.digibooky.util.Address;
import be.switchfully.codecavalry.digibooky.util.MailAddress;
import be.switchfully.codecavalry.digibooky.util.SocialSecurityNumber;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemberRepository {

    private Map<String, Member> members;

    public MemberRepository() {
        this.members = new HashMap<>();
        addFirstMember();
    }

    public void addFirstMember() {
        Member member = new Member(new SocialSecurityNumber("671220-333-73"), "Pascal", "Baelen",
                new MailAddress("pascal.baelen@live.com"),
                new Address("Fakestreet", "95", "Geraardsbergen", 9500));
        members.put(member.getId(), member);
    }

    public Member save(Member member){
        if(members.containsValue(member)) throw new MemberAlreadyExistsException(member.getFirstname() + " " + member.getLastname());
         members.put(member.getId(), member);

         return member;
    }

    public List<Member> getMembers(){
        return new ArrayList<>(members.values());
    }

    public Map<String, Member> getMemberMap ()
    {
        return members;
    }

}
