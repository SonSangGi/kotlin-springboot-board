package dev.sanggi.board.controller

import dev.sanggi.board.domain.Board
import dev.sanggi.board.domain.QBoard
import dev.sanggi.board.repository.BoardRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @@author SonSangGi
 * @created 2020/03/17
 */
@RestController
class BoardController(private val boardRepository: BoardRepository) {

    @PutMapping("/board")
    fun insertBoard(board: Board) = boardRepository.save(board)

    @GetMapping("/board")
    fun getAllBoards(): Page<Board> = boardRepository.findAll(PageRequest.of(1, 10))
}