package repository.impl;

import model.Member;
import repository.MemberRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepositoryImpl implements MemberRepository {
    private Map<Integer,Member> members = new HashMap<Integer,Member>();
    @Override
    public void addMember(Member member) {
        members.put(member.getId(),member);
    }
    @Override
    public void updateMember(Member member) {
         members.put(member.getId(),member);
    }
    @Override
    public void deleteMember(int id) {
        members.remove(id);

    }
    @Override
    public List<Member> getAllMembers() {

        return new ArrayList<>(members.values());
    }

    @Override
    public List<Member> searchMembersByName(String name) {
        List<Member>memberList = new ArrayList<>();
        for(Member member:members.values())
        {
            if(name.equals(member.getName()))
            {
                memberList.add(member);
            }
        }
        return memberList;
    }

    @Override
    public Member searchMembersById(int id) {
        return members.get(id);
    }

    @Override
    public Member getMemberByEmail(String email) {
        for(Member member:members.values())
        {
            if(member.getEmail().equals(email))
            {
                return member;
            }
        }
        return null;
    }
}
