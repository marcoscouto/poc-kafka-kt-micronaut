package com.marcoscoutozup.consumer

import com.marcoscoutozup.dto.TransacaoDto
import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.configuration.kafka.annotation.KafkaListener
import io.micronaut.configuration.kafka.annotation.OffsetReset
import io.micronaut.configuration.kafka.annotation.Topic
import org.slf4j.LoggerFactory

@KafkaListener(offsetReset = OffsetReset.EARLIEST)
class Consumer {

    val log = LoggerFactory.getLogger(Consumer::class.java)

    @Topic("\${topic}")
    fun ouvindoTopico(@KafkaKey operation: String, transacao: TransacaoDto){
        log.info("[CONSUMER] Recebendo transacao {}", transacao)
    }

}
