package rhcwlq89.study.member.service

import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import rhcwlq89.study.member.domain.dto.SignInRequest
import rhcwlq89.study.member.domain.dto.SignInResponse
import rhcwlq89.study.member.domain.dto.SignUpRequest
import rhcwlq89.study.member.domain.dto.SignUpResponse
import rhcwlq89.study.member.domain.exception.AlreadyMemberNameException
import rhcwlq89.study.member.domain.exception.NotMatchEmailOrPasswordException
import rhcwlq89.study.member.domain.logger
import rhcwlq89.study.member.repository.MemberRepository

@Transactional
@Service
class SignService(private val memberRepository: MemberRepository) {
    private val logger = logger()
    private val passwordEncoder: PasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()

    fun signUp(signUpRequest: SignUpRequest): SignUpResponse {
        if (memberRepository.existsByEmail(signUpRequest.email)) {
            throw AlreadyMemberNameException()
        }

        val member = signUpRequest.toEntity()
        val encode = passwordEncoder.encode(signUpRequest.password)
        member.password = encode

        memberRepository.save(member)

        return SignUpResponse("success")
    }

    fun signIn(signInRequest: SignInRequest): SignInResponse {
        val member = memberRepository.findMemberByEmail(signInRequest.email) ?: throw NotMatchEmailOrPasswordException()
        if (!passwordEncoder.matches(signInRequest.password, member.password)) {
            throw NotMatchEmailOrPasswordException()
        }

        return SignInResponse("success")
    }
}