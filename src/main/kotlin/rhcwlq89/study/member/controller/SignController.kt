package rhcwlq89.study.member.controller

import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import rhcwlq89.study.member.domain.dto.SignInRequest
import rhcwlq89.study.member.domain.dto.SignUpRequest
import rhcwlq89.study.member.service.SignService

@RestController
class SignController(private val signService: SignService) {

    @PostMapping("/sign-in")
    fun signIn(@RequestBody signInRequest: SignInRequest) {
        signService.signIn(signInRequest)
    }

    @PostMapping("/sign-up")
    fun signUp(@RequestBody signUpRequest: SignUpRequest) {
        signService.signUp(signUpRequest)
    }

}