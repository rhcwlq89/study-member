package rhcwlq89.study.member.domain.dto

import javax.validation.constraints.NotEmpty

data class SignInRequest(
    @field:NotEmpty
    val email: String,
    @field:NotEmpty
    val password: String
)