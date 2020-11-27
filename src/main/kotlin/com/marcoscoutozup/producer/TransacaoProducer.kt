package com.marcoscoutozup.producer

import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.configuration.kafka.annotation.Topic

@KafkaClient
interface TransacaoProducer {

    @Topic("transacoes")
    fun sendTransacao(@KafkaKey operation: String, name: TransacaoDto)

}