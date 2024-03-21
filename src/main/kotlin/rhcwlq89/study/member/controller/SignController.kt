package rhcwlq89.study.member.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import rhcwlq89.study.member.domain.dto.SignInRequest
import rhcwlq89.study.member.domain.dto.SignInResponse
import rhcwlq89.study.member.domain.dto.SignUpRequest
import rhcwlq89.study.member.domain.dto.SignUpResponse
import rhcwlq89.study.member.domain.dto.common.CommonResponse
import rhcwlq89.study.member.service.SignService

@RestController
class SignController(private val signService: SignService) {

    @PostMapping("/sign-up")
    fun signUp(@RequestBody signUpRequest: SignUpRequest): CommonResponse<SignUpResponse> {
        return CommonResponse(data = signService.signUp(signUpRequest))
    }

    @PostMapping("/sign-in")
    fun signIn(@RequestBody signInRequest: SignInRequest): CommonResponse<SignInResponse> {
        return CommonResponse(data = signService.signIn(signInRequest))
    }

}