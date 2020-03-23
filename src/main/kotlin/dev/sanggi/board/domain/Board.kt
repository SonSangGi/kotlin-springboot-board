package dev.sanggi.board.domain

import com.fasterxml.jackson.annotation.JsonFormat
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import java.time.LocalDateTime
import javax.persistence.*

/**
 * @@author SonSangGi
 * @created 2020/03/17
 */
@Entity
@DynamicInsert
@DynamicUpdate
data class Board(@Id
                 @GeneratedValue(strategy = GenerationType.AUTO)
                 var no: Long? = null,
                 var title: String? = null,
                 var content: String? = null,
                 var writer: String? = null,
                 var password: String? = null,
                 @Column(name = "created", columnDefinition = "timestamp default current_timestamp")
                 var created: LocalDateTime? = null
)