package net.tinymin.microcosmos.member.model

import io.swagger.v3.oas.annotations.media.Schema
import net.tinymin.microcosmos.common.model.BaseTimeEntity
import org.hibernate.annotations.DynamicUpdate
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotNull

@Schema(hidden = true)
@DynamicUpdate
@Entity(name = "member")
class Member (
    @get:Id @get:GeneratedValue
    var id: Long? = null,

    @field:NotNull(message = "member.email.notnull")
    var email: String,

    @field:NotNull(message = "member.name.notnull")
    var name: String,

    @get:Enumerated(EnumType.STRING)
    var status: MemberStatus,

    var cellPhone: String?,
    var telePhone: String?,

    @Embedded
    var address: Address?,

    createdAt: LocalDateTime?,
    updatedAt: LocalDateTime?,
    createdBy: String,
    updatedBy: String,
) : BaseTimeEntity(createdAt, updatedAt, createdBy, updatedBy) {
    companion object {
        fun create(joinRequest: JoinRequest): Member {
            val address = Address(
                joinRequest.country,
                joinRequest.state,
                joinRequest.city,
                joinRequest.street1,
                joinRequest.street2,
                joinRequest.zipcode
            )

            return Member(email = joinRequest.email
                , name = joinRequest.name
                , status = MemberStatus.NORMAL
                , cellPhone = joinRequest.cellPhone
                , telePhone = joinRequest.telePhone
                , address = address
                , createdAt = null
                , updatedAt = null
                , createdBy = joinRequest.email
                , updatedBy = joinRequest.email)
        }
    }

    fun edit(editRequest: EditRequest): Member {
        this.name = editRequest.name ?: this.name
        this.cellPhone = editRequest.cellPhone ?: this.cellPhone
        this.telePhone = editRequest.telePhone ?: this.telePhone
        this.address?.country = editRequest.country ?: this.address?.country
        this.address?.state =  editRequest.state ?: this.address?.state
        this.address?.city = editRequest.city ?: this.address?.city
        this.address?.street1 = editRequest.street1 ?: this.address?.street1
        this.address?.street2 = editRequest.street2 ?: this.address?.street2
        this.address?.zipcode = editRequest.zipcode ?: this.address?.zipcode
        this.updatedBy = this.email

        return this
    }

    fun closure(): Member {
        this.status = MemberStatus.CLOSURE
        this.updatedBy = this.email

        return this
    }

    fun restore(requester: String): Member {
        this.status = MemberStatus.NORMAL
        this.updatedBy = requester

        return this
    }

    fun ban(requester: String): Member {
        this.status = MemberStatus.BANNED
        this.updatedBy = requester

        return this
    }
}