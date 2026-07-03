package service;

import model.Member;

import java.util.List;

public interface MemberService {
    void addMember(Member member);
    void updateMember(Member member);
    void deleteMember(int id);
    List<Member> getAllMembers();
    Member getMembersById(int id);
    Member searchMemberByID(int id);
    List<Member> searchMembersByName(String name);
    Member getMemberByEmail(String email);

}




