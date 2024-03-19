package rhcwlq89.study.member.service

import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import rhcwlq89.study.member.domain.dto.SignInRequest
import rhcwlq89.study.member.domain.dto.SignUpRequest
import rhcwlq89.study.member.domain.exception.NotMatchEmailOrPasswordException
import rhcwlq89.study.member.repository.MemberRepository

@Service
class SignService(private val memberRepository: MemberRepository) {
    private val passwordEncoder: PasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()

    fun signUp(signUpRequest: SignUpRequest) {
        val member = signUpRequest.toEntity()
        memberRepository.save(member)
    }

    fun signIn(signInRequest: SignInRequest): String {
        val member = memberRepository.findMemberByEmail(signInRequest.email) ?: throw NotMatchEmailOrPasswordException()
        if (!passwordEncoder.matches(signInRequest.password, member.password)) {
            throw NotMatchEmailOrPasswordException()
        }

        return "success"
    }
}