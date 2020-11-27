package com.marcoscoutozup.producer

import java.math.BigDecimal
import java.time.LocalDateTime

data class TransacaoDto (val id: String, val valor: BigDecimal, val data: LocalDateTime)