package rhcwlq89.study.member.domain.entity

import BaseEntity
import jakarta.persistence.*
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

@Entity
class Member(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var memberUid: Long? = null,
    @Column var memberName: String,
    @Column var email: String,
    @Column var password: String,
    @Column var phoneNumber: String,
    @Column var birthDate: String,
    @Column var deletedYn: Boolean,
    @Column var lastSignInAt: LocalDateTime?,
) : BaseEntity()