package net.tinymin.microcosmos.member

import net.tinymin.microcosmos.common.model.Requester
import net.tinymin.microcosmos.member.dto.MemberDto
import net.tinymin.microcosmos.member.model.Member
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/v1")
class MemberMaintenanceController(private val memberService: MemberService) {
    @GetMapping("/members")
    fun getAllMembers() : List<Member>  {
        return memberService.getAllMembers()
    }

    @PutMapping("/members/{memberId}/restore")
    fun restoreMember(@PathVariable memberId: Long, @RequestBody @Valid requester: Requester): MemberDto {
        return memberService.restoreMember(memberId, requester.requester)
    }

    @DeleteMapping("/members/{memberId}/ban")
    fun banMember(@PathVariable memberId: Long, @RequestBody @Valid requester: Requester) : MemberDto {
        return memberService.ban(memberId, requester.requester)
    }
}