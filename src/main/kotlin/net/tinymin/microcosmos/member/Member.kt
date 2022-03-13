package net.tinymin.microcosmos.member

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity(name = "member")
open class Member(
    @get:Id @get:GeneratedValue
    open var id: Long?= null,

    @field:NotNull(message = "member.email.notnull")
    open var email: String,

    @field:NotNull(message = "member.name.notnull")
    open var name: String,

    @get:Enumerated(EnumType.STRING)
    open var status: MemberStatus,

    open var cellPhone: String?,
    open var telePhone: String?,

    @Embedded
    open var address: Address?
) {

}
