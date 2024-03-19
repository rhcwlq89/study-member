package rhcwlq89.study.member.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import rhcwlq89.study.member.domain.dto.SignUpRequest
import rhcwlq89.study.member.service.SignService

@RestController
class SignController(private val signService: SignService) {

    @PostMapping("/sign-in")
    fun signIn() {
        signService.signIn()
    }

    @PostMapping("/sign-up")
    fun signUp(signUpRequest: SignUpRequest) {
        signService.signUp(signUpRequest)
    }

}