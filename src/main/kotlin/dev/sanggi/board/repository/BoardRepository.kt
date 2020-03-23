package dev.sanggi.board.repository

import dev.sanggi.board.domain.Board
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.stereotype.Repository
import java.util.*

/**
 * @@author SonSangGi
 * @created 2020/03/17
 */
@Repository
interface BoardRepository: JpaRepository<Board, Long>, QuerydslPredicateExecutor<Board> {
    override fun findAll(pageable: Pageable):Page<Board>
}