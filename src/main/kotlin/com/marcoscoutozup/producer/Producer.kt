package com.marcoscoutozup.producer

import io.micronaut.scheduling.annotation.Scheduled
import org.slf4j.LoggerFactory
import java.math.BigDecimal
import java.math.RoundingMode
import java.time.LocalDateTime
import java.util.*
import javax.inject.Singleton
import kotlin.random.asKotlinRandom

@Singleton
class Producer(val producer: TransacaoProducer) {

    val log = LoggerFactory.getLogger(Producer::class.java)

    @Scheduled(fixedRate = "\${timer.producer}")
    fun gerarTransacao(){
        val idTransacao = UUID.randomUUID().toString()
        val transacao = TransacaoDto(
                idTransacao,
                BigDecimal(Random()
                        .asKotlinRandom()
                        .nextDouble(10.00, 1000.00))
                        .setScale(2, RoundingMode.CEILING),
                LocalDateTime.now())

        log.info("[PRODUCER] Gerando transação: {}", transacao)
        producer.sendTransacao(idTransacao, transacao)
    }

}