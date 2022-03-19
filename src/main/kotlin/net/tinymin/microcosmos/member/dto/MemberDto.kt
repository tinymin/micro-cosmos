package net.tinymin.microcosmos.member.dto

import net.tinymin.microcosmos.common.model.BaseTimeEntity
import net.tinymin.microcosmos.member.model.Address
import net.tinymin.microcosmos.member.model.Member
import net.tinymin.microcosmos.member.model.MemberStatus
import java.time.LocalDateTime

class MemberDto(
    var id: Long?,
    var email: String,
    var name: String,
    var status: MemberStatus,
    var cellPhone: String?,
    var telePhone: String?,
    var address: Address?,
    createdAt: LocalDateTime?,
    updatedAt: LocalDateTime?,
    createdBy: String,
    updatedBy: String,
) : BaseTimeEntity(createdAt, updatedAt, createdBy, updatedBy) {
    companion object {
        @JvmStatic
        fun ofMember(member: Member): MemberDto {
            return MemberDto(member.id
                , member.email
                , member.name
                , member.status
                , member.cellPhone
                , member.telePhone
                , member.address
                , member.createdAt
                , member.updatedAt
                , member.createdBy
                , member.updatedBy
            )
        }
    }
}
