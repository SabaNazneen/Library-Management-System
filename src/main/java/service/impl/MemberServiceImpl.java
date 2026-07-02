package service.impl;

import model.Member;
import repository.MemberRepository;
import service.MemberService;

import java.util.List;

public class MemberServiceImpl implements MemberService {
    private MemberRepository memberRepository;
    @Override
    public void addMember(Member member) {

    }

    @Override
    public void updateMember(Member member) {

    }

    @Override
    public void deleteMember(int id) {

    }

    @Override
    public List<Member> getAllMembers() {
        return List.of();
    }

    @Override
    public Member searchMemberByID(int id) {
        return null;
    }
}
