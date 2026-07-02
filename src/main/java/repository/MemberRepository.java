package repository;

import model.Member;

import java.util.List;

public interface MemberRepository {
    void addMember(Member member);
    void updateMember(Member member);
    void deleteMember(int id);
    List<Member> getAllMembers();
    Member getMember(int id);
    List<Member>searchMembersByName(String name);
    Member getMemberByEmail(String email);
}
