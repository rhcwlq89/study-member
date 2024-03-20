package rhcwlq89.study.member.domain.dto

import rhcwlq89.study.member.domain.entity.Member
import java.time.LocalDateTime
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Pattern

data class SignUpRequest(
    @field:NotEmpty
    val memberName: String,
    @field:NotEmpty
    val password: String,
    @field:Email
    val email: String,
    @field:Pattern(regexp = "/(?:([+]\\d{1,4})[-.\\s]?)?(?:[(](\\d{1,3})[)][-.\\s]?)?(\\d{1,4})[-.\\s]?(\\d{1,4})[-.\\s]?(\\d{1,9})/g")
    val phoneNumber: String,
    @field:Pattern(regexp = "/(\\d{4})[-.\\s](\\d{2})[-.\\s](\\d{2})")
    val birthDate: String,
) {
    fun toEntity(): Member {
        return Member(
            memberName = memberName,
            password = password,
            email = email,
            phoneNumber = phoneNumber,
            birthDate = birthDate,
            lastSignInAt = LocalDateTime.now(),
            deletedYn = false
        )
    }
}