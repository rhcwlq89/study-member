package rhcwlq89.study.member.domain.dto.common

data class CommonResponse<T>(val code: String = "200", val message: String = "success", val data: T)