package net.tinymin.microcosmos.member

import javax.persistence.Embeddable

@Embeddable
data class Address(
    var country: String?,
    var state: String?,
    var city: String?,
    var street1: String?,
    var street2: String?,
    var zipcode: String?,
)
