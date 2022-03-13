package net.tinymin.microcosmos.member.dto

import net.tinymin.microcosmos.member.Address
import net.tinymin.microcosmos.member.Member
import net.tinymin.microcosmos.member.MemberStatus

data class MemberClosureDto(
    override var id: Long? = null,
    override var email: String,
    override var name: String,
    override var status: MemberStatus,
    override var cellPhone: String?,
    override var telePhone: String?,
    override var address: Address?
): Member(id, email, name, status, cellPhone, telePhone, address) {
}
