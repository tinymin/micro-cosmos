package net.tinymin.microcosmos.member.model

data class EditRequest (
    val name: String?= null,
    val cellPhone: String?= null,
    val telePhone: String?= null,
    val country: String?= null,
    val state: String?= null,
    val city: String?= null,
    val street1: String?= null,
    val street2: String?= null,
    val zipcode: String?= null
)
