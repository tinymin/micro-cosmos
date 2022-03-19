package net.tinymin.microcosmos.member.model

import io.swagger.v3.oas.annotations.media.Schema
import javax.persistence.Embeddable

@Schema(hidden = true)
@Embeddable
class Address(
    var country: String?,
    var state: String?,
    var city: String?,
    var street1: String?,
    var street2: String?,
    var zipcode: String?,
)
