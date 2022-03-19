package net.tinymin.microcosmos.member.model

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class JoinRequest (
    @field:Email
    @field:NotEmpty(message = "join.request.email.notempty")
    val email: String,
    @field:NotEmpty(message = "join.request.name.notempty")
    val name: String,

    val cellPhone: String?= null,
    val telePhone: String?= null,
    val country: String?= null,
    val state: String?= null,
    val city: String?= null,
    val street1: String?= null,
    val street2: String?= null,
    val zipcode: String?= null
)
