package dev.sanggi.board.controller

import dev.sanggi.board.domain.Board
import dev.sanggi.board.domain.QBoard
import dev.sanggi.board.repository.BoardRepository
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.HttpClientErrorException
import java.nio.file.attribute.UserPrincipalNotFoundException

/**
 * @@author SonSangGi
 * @created 2020/03/17
 */
@RestController
class BoardController(private val boardRepository: BoardRepository) {

    private val log = LoggerFactory.getLogger(BoardController::class.java)

    @PutMapping("/board")
    fun insertBoard(board: Board) {
        if (board.no != null) {
        } else
            boardRepository.save(board)
    }

    @GetMapping("/board")
    fun getAllBoards(@RequestParam(defaultValue = "0") page: Int, @RequestParam(defaultValue = "") keyword: String): Page<Board> =
            boardRepository.findAll(
                    QBoard.board.title.contains(keyword),
                    PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "created")))
}