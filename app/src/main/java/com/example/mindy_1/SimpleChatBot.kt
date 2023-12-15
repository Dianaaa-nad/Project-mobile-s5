package com.example.mindy_1
import java.util.*

class SimpleChatBot {
    private val rules = listOf(
        Rule("hello", "Hi there!"),
        Rule("how are you", "I'm doing well, thank you."),
        Rule("what's your name", "I'm a simple chatbot."),
        Rule("bye", "Goodbye!"),
        Rule("default", "I'm not sure how to respond to that.")
    )

    fun generateResponse(userInput: String): String {
        val normalizedInput = userInput.toLowerCase(Locale.getDefault())

        for (rule in rules) {
            if (normalizedInput.contains(rule.pattern)) {
                return rule.response
            }
        }

        return rules.find { it.pattern == "default" }?.response ?: ""
    }
}

data class Rule(val pattern: String, val response: String)
