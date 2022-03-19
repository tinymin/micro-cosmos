package net.tinymin.microcosmos.member

import net.tinymin.microcosmos.member.dto.MemberDto
import net.tinymin.microcosmos.member.model.EditRequest
import net.tinymin.microcosmos.member.model.JoinRequest
import net.tinymin.microcosmos.member.model.Member
import org.springframework.stereotype.Service

@Service
class MemberService (private val memberRepository: MemberRepository) {
    fun joinMember(joinRequest: JoinRequest): MemberDto {
        val newMember = Member.create(joinRequest)
        memberRepository.save(newMember)

        return MemberDto.ofMember(newMember)
    }

    fun getMember(memberId: Long): Member {
        return memberRepository.findById(memberId).orElseThrow()
    }

    fun closureMember(memberId: Long): MemberDto {
        val member = getMember(memberId)
        val closuredMember = member.closure()
        memberRepository.save(closuredMember)

        return MemberDto.ofMember(member)
    }

    fun editMember(memberId: Long, editRequest: EditRequest): MemberDto {
        val member = getMember(memberId)
        val editedMember = member.edit(editRequest)
        memberRepository.save(editedMember)

        return MemberDto.ofMember(editedMember)
    }

    fun restoreMember(memberId: Long, requester: String): MemberDto {
        val member = getMember(memberId)
        val restoredMember = member.restore(requester)
        memberRepository.save(restoredMember)

        return MemberDto.ofMember(restoredMember)
    }

    fun ban(memberId: Long, requester: String): MemberDto {
        val member = getMember(memberId)
        val bannedMember = member.ban(requester)
        memberRepository.save(bannedMember)

        return MemberDto.ofMember(bannedMember)
    }
}