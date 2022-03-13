package net.tinymin.microcosmos.member

import net.tinymin.microcosmos.member.dto.MemberClosureDto
import org.springframework.stereotype.Service

@Service
class MemberService (private val memberRepository: MemberRepository) {
    fun memberJoin(joinRequest: JoinRequest): Member {
        return memberRepository.save(joinRequest.toMember())
    }

    fun getMember(memberId: Long): Member {
        return memberRepository.findById(memberId).orElseThrow()
    }

    fun closureMember(memberId: Long): MemberClosureDto {
        val member = getMember(memberId)
        member.status = MemberStatus.CLOSURE
        memberRepository.save(member)
        return MemberClosureDto(memberId, member.email, member.name, member.status, member.cellPhone,member.telePhone,member.address)
    }
}