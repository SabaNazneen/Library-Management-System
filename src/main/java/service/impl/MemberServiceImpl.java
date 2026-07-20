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
        Member existing = memberRepository.searchMembersById(member.getId());
        if(existing == null){
            System.out.println("Member with ID " + member.getId() + " does not exist");
            return;
        }
        existing.setName(member.getName());
        existing.setEmail(member.getEmail());
        existing.setPhone(member.getPhone());
        memberRepository.updateMember(existing);
    }

    @Override
    public void deleteMember(int id) {
        Member existing = memberRepository.searchMembersById(id);
        if(existing == null){
            System.out.println("Member with ID " + id + " does not exist");
            return;
        }
        memberRepository.deleteMember(id);
    }

    @Override
    public List<Member> getAllMembers() {

        return memberRepository.getAllMembers();
    }



    @Override
    public Member getMemberByEmail(String email) {
        return  memberRepository.getMemberByEmail(email);
    }

    @Override
    public Member searchMemberByID(int id) {
        Member existing = memberRepository.searchMembersById(id);
        if(existing == null){
            System.out.println("Member with ID " + id + " does not exist");
            return null;
        }
        System.out.println("Member with ID " + id + " found");
        return existing;
    }

    @Override
    public List<Member> searchMembersByName(String name) {
        return  memberRepository.searchMembersByName(name);
    }
}
