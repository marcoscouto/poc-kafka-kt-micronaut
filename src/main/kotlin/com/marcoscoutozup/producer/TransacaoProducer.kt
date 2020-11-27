package com.marcoscoutozup.producer

import com.marcoscoutozup.dto.TransacaoDto
import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.configuration.kafka.annotation.Topic

@KafkaClient
interface TransacaoProducer {

    @Topic("\${topic}")
    fun sendTransacao(@KafkaKey operation: String, transacao: TransacaoDto)

}