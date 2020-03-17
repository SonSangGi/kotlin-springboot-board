package dev.sanggi.board.controller

import dev.sanggi.board.repository.BoardRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

/**
 * @@author SonSangGi
 * @created 2020/03/17
 */
@Controller
class HomeController {


    @GetMapping("/")
    fun list(model: Model): String {
        return "list"
    }

}