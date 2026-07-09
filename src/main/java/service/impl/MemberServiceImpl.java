package service.impl;

import model.Member;
import repository.MemberRepository;
import repository.impl.MemberRepositoryImpl;
import service.MemberService;

import java.util.List;

public class MemberServiceImpl implements MemberService {
    private MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void addMember(Member member) {
        memberRepository.addMember(member);
    }

    @Override
    public void updateMember(Member member) {
        memberRepository.updateMember(member);
    }

    @Override
    public void deleteMember(int id) {
        memberRepository.deleteMember(id);
    }

    @Override
    public List<Member> getAllMembers() {

        return memberRepository.getAllMembers();
    }

    @Override
    public Member getMembersById(int id) {
        return memberRepository.getMemberByID(id);
    }

    @Override
    public Member getMemberByEmail(String email) {
        return  memberRepository.getMemberByEmail(email);
    }

    @Override
    public Member searchMemberByID(int id) {
        return memberRepository.searchMembersById(id);
    }

    @Override
    public List<Member> searchMembersByName(String name) {
        return  memberRepository.searchMembersByName(name);
    }
}
