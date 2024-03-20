package rhcwlq89.study.member.domain

import io.github.oshai.kotlinlogging.KotlinLogging

//inline fun <reified T> T.logger() = LoggerFactory.getLogger(T::class.java)!!
inline fun <reified T> T.logger() = KotlinLogging.logger(T::class.qualifiedName!!)