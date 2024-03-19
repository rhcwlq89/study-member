package rhcwlq89.study.member.domain.exception

open class CommonException : RuntimeException() {

}

open class MemberException(val errorCode: ErrorCode) : CommonException()

class NotFoundMemberException : MemberException(errorCode = ErrorCode.ERR001)
class AlreadyMemberNameException : MemberException(errorCode = ErrorCode.ERR002)

class NotMatchEmailOrPasswordException : MemberException(errorCode = ErrorCode.ERR003)

enum class ErrorCode(val code: String, val message: String) {
    ERR000("ERR000", "알 수 없는 에러가 발생했습니다."),
    ERR001("ERR001", "해당 회원이 존재하지 않습니다."),
    ERR002("ERR002", "이미 가입한 회원명 입니다."),
    ERR003("ERR003", "이메일과 비밀번호가 일치하지 않습니다.");
}