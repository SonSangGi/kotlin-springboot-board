package dev.sanggi.board.controller

import com.querydsl.core.BooleanBuilder
import dev.sanggi.board.domain.QBoard
import dev.sanggi.board.repository.BoardRepository
import org.slf4j.LoggerFactory
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

/**
 * @@author SonSangGi
 * @created 2020/03/17
 */
@Controller
class HomeController(private val boardRepository: BoardRepository) {

    private val log = LoggerFactory.getLogger(HomeController::class.java)

    @GetMapping("/")
    fun list(model: Model,
             @RequestParam(defaultValue = "1") page: Int,
             @RequestParam(defaultValue = "") keyword: String,
             @RequestParam(defaultValue = "A") type: String): String {

        val builder = BooleanBuilder()

        when (type) {
            "A" -> builder.and(QBoard.board.title.contains(keyword)).or(QBoard.board.content.contains(keyword))
            "T" -> builder.and(QBoard.board.title.contains(keyword))
            "C" -> builder.and(QBoard.board.content.contains(keyword))
        }

        model["pages"] = boardRepository.findAll(
                builder,
                PageRequest.of(page - 1, 10, Sort.by(Sort.Direction.DESC, "created")))

        return "list"
    }

    @GetMapping("/detail")
    fun detail(model: Model, @RequestParam no: Long): String {
        model["board"] = boardRepository.findById(no).orElse(null)
        return "detail"
    }
}