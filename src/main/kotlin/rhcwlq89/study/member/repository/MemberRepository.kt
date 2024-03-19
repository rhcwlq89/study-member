package rhcwlq89.study.member.repository

import org.springframework.data.jpa.repository.JpaRepository
import rhcwlq89.study.member.domain.entity.Member


interface MemberRepository : JpaRepository<Member, Long> {
}