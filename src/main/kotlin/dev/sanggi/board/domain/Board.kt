package dev.sanggi.board.domain

import java.time.LocalDateTime
import javax.persistence.*

/**
 * @@author SonSangGi
 * @created 2020/03/17
 */
@Entity
data class Board(@Id
                 @GeneratedValue(strategy = GenerationType.AUTO)
                 var no: Long? = null,
                 var title: String? = null,
                 var content: String? = null,
                 var created: LocalDateTime? = null)