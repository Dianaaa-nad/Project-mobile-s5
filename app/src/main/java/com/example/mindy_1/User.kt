package com.example.mindy_1

import androidx.room.Entity
import java.time.LocalDate  // Use java.time.LocalDate if available

enum class Gender {
    MALE, FEMALE, OTHER
}

enum class Job {
    STUDENT, WORKER, LAINNYA
}
@Entity(tableName = "users")
data class User(
    val id: Int,
    val name: String,
    val email: String,
    val password: String,
    val ttl: LocalDate,
    val gender: Gender,
    val job: Job
)
