package net.tinymin.microcosmos.member

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class JoinRequest (
    @field:Email
    @field:NotEmpty(message = "join.request.email.notempty")
    private val email: String,
    @field:NotEmpty(message = "join.request.name.notempty")
    private val name: String,

    private val cellPhone: String?= null,
    private val telePhone: String?= null,
    private val country: String?= null,
    private val state: String?= null,
    private val city: String?= null,
    private val street1: String?= null,
    private val street2: String?= null,
    private val zipcode: String?= null
) {
    fun toMember(): Member {
        val address = Address(country, state, city, street1, street2, zipcode)
        return Member(name = name, email = email, status = MemberStatus.NORMAL, cellPhone = cellPhone, telePhone = telePhone, address = address)
    }
}
