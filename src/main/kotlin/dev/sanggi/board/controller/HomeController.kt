package dev.sanggi.board.controller

import dev.sanggi.board.repository.BoardRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.domain.PageRequest
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
    fun list(model: Model, @RequestParam(defaultValue = "0") page: Int?): String {
        log.info("$page")
        model["list"] = boardRepository.findAll(PageRequest.of(0, 10))
        return "list"
    }

}