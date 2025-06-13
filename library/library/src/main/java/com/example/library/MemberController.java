package com.example.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    // List all members
    @GetMapping
    public String getAllMembers(Model model) {
        model.addAttribute("members", memberRepository.findAll());
        return "members";
    }

    // View member details (optional - if you want details page)
    @GetMapping("/{id}")
    public String getMemberById(@PathVariable UUID id, Model model) {
        Optional<Member> member = memberRepository.findById(id);
        member.ifPresent(value -> model.addAttribute("member", value));
        return "member-details";
    }

    // Show Add Member form
    @GetMapping("/add")
    public String showAddMemberForm(Model model) {
        model.addAttribute("member", new Member());
        return "add-member";
    }

    @PostMapping("/add")
    public String addMember(@ModelAttribute Member member) {
        memberRepository.save(member);
        return "redirect:/members";
    }

    // Show Edit Member form
    @GetMapping("/edit/{id}")
    public String showEditMemberForm(@PathVariable UUID id, Model model) {
        Optional<Member> member = memberRepository.findById(id);
        member.ifPresent(value -> model.addAttribute("member", value));
        return "edit-member";
    }

    // Handle Edit Member form submission
    @PostMapping("/edit/{id}")
    public String updateMember(@PathVariable UUID id, @ModelAttribute Member updatedMember) {
        Optional<Member> existingMember = memberRepository.findById(id);
        if (existingMember.isPresent()) {
            Member member = existingMember.get();
            member.setName(updatedMember.getName());
            member.setJoinDate(updatedMember.getJoinDate());
            member.setIssuedBooks(updatedMember.getIssuedBooks());
            member.setActive(updatedMember.isActive());
            memberRepository.save(member);
        }
        return "redirect:/members";
    }

    // Delete member
    @GetMapping("/delete/{id}")
    public String deleteMember(@PathVariable UUID id) {
        memberRepository.deleteById(id);
        return "redirect:/members";
    }
}
