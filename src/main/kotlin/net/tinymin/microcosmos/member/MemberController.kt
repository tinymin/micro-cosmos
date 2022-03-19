package net.tinymin.microcosmos.member

import net.tinymin.microcosmos.member.dto.MemberDto
import net.tinymin.microcosmos.member.model.EditRequest
import net.tinymin.microcosmos.member.model.JoinRequest
import net.tinymin.microcosmos.member.model.Member
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/v1")
class MemberController(private val memberService: MemberService) {
    @PostMapping("/members/join")
    fun memberJoin(@RequestBody @Valid joinRequest: JoinRequest): MemberDto {
        return memberService.joinMember(joinRequest);
    }

    @GetMapping("/members/{memberId}")
    fun getMember(@PathVariable memberId: Long) : Member {
        return memberService.getMember(memberId);
    }

    @PutMapping("/members/{memberId}")
    fun editMember(@PathVariable memberId: Long, @RequestBody @Valid editRequest: EditRequest): MemberDto {
        return memberService.editMember(memberId, editRequest);
    }

    @DeleteMapping("/members/{memberId}/closure")
    fun closureMember(@PathVariable memberId: Long) : MemberDto {
        return memberService.closureMember(memberId)
    }
}