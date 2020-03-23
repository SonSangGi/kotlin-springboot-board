package dev.sanggi.board.config

import dev.sanggi.board.domain.Board
import dev.sanggi.board.repository.BoardRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import java.time.LocalDateTime

/**
 * @@author SonSangGi
 * @created 2020/03/17
 */
@Component
class DataLoader(private val boardRepository: BoardRepository) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        for (i in 1..105) {
            boardRepository.save(Board(title = "게시글$i", content = "내용${105 - i}", writer = "USER$i", password = "1234"))
        }
    }
}