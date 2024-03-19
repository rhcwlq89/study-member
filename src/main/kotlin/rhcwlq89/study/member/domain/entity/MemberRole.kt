package rhcwlq89.study.member.domain.entity

import jakarta.persistence.*

@Entity
class MemberRole(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var memberRoleUid: Long?,
    @Column var memberUid: Long?,
    @Column var roleUid: Long?
)