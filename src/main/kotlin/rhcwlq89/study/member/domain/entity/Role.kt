package rhcwlq89.study.member.domain.entity

import BaseEntity
import jakarta.persistence.*

@Entity
class Role(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var roleUid: Long?,
    @Column var roleName: String
) : BaseEntity()