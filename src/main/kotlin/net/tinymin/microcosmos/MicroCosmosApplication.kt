package net.tinymin.microcosmos

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class MicroCosmosApplication

fun main(args: Array<String>) {
	runApplication<MicroCosmosApplication>(*args)
}
