package net.tinymin.microcosmos.member

import net.tinymin.microcosmos.member.dto.MemberClosureDto
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
class MemberController(private val memberService: MemberService) {
    @PostMapping("/members/join")
    fun memberJoin(@RequestBody @Valid joinRequest: JoinRequest): Member {
        return memberService.memberJoin(joinRequest);
    }

    @GetMapping("/members/{memberId}")
    fun getMember(@PathVariable memberId: Long) : Member {
        return memberService.getMember(memberId);
    }

    @GetMapping("/members/{memberId}/closure")
    fun closureMember(@PathVariable memberId: Long) : MemberClosureDto {
        return memberService.closureMember(memberId)
    }
}