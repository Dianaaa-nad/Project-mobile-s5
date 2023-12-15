package com.example.mindy_1

import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class OpenAiChatbot(private val apiKey: String) {

    fun getChatbotResponse(userMessage: String): String {
        val url = "https://api.openai.com/v1/engines/davinci-codex/completions" // Adjust the endpoint based on OpenAI API

        val client = OkHttpClient()

        val json = JSONObject()
        json.put("prompt", userMessage)
        json.put("max_tokens", 100)

        val mediaType = "application/json; charset=utf-8".toMediaTypeOrNull()
        val body = RequestBody.create(mediaType, json.toString())

        val request = Request.Builder()
            .url(url)
            .addHeader("Authorization", "Bearer $apiKey")
            .post(body)
            .build()

        try {
            val response = client.newCall(request).execute()
            if (response.isSuccessful) {
                val responseBody = response.body?.string()
                return parseChatbotResponse(responseBody)
            } else {
                // Handle unsuccessful response
                return "Chatbot couldn't provide a response."
            }
        } catch (e: IOException) {
            // Handle exception
            return "Error communicating with the chatbot."
        }
    }

    private fun parseChatbotResponse(responseBody: String?): String {
        try {
            val jsonObject = JSONObject(responseBody)
            return jsonObject.getString("choices")
        } catch (e: JSONException) {
            // Handle JSON parsing exception
            return "Error parsing chatbot response."
        }
    }
}
