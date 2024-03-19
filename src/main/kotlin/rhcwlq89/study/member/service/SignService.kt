package rhcwlq89.study.member.service

import org.springframework.stereotype.Service
import rhcwlq89.study.member.domain.dto.SignUpRequest
import rhcwlq89.study.member.repository.MemberRepository

@Service
class SignService(private val memberRepository: MemberRepository) {

    fun signUp(signUpRequest: SignUpRequest) {
        val member = signUpRequest.toEntity()
        memberRepository.save(member)
    }

    fun signIn() {

    }
}