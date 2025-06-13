package com.example.library;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> getMemberById(UUID id) {
        return memberRepository.findById(id);
    }

    public List<Member> getActiveMembers() {
        return memberRepository.findByActiveTrue();
    }

    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    public Member updateMember(UUID id, Member updatedMember) {
        return memberRepository.findById(id).map(member -> {
            member.setName(updatedMember.getName());
            member.setJoinDate(updatedMember.getJoinDate());
            member.setIssuedBooks(updatedMember.getIssuedBooks());
            member.setActive(updatedMember.isActive());
            return memberRepository.save(member);
        }).orElseThrow(() -> new RuntimeException("Member not found"));
    }
}
