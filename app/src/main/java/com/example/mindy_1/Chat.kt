package com.example.mindy_1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class Chat : AppCompatActivity() {
    private lateinit var chatAdapter: ChatAdapter
    private lateinit var editTextMessage: EditText
    private lateinit var buttonSend: Button
    private lateinit var recyclerViewChat: RecyclerView

    // Initialize OpenAI chatbot
    private val openAiChatbot = OpenAiChatbot("Your_API_Key")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        val chatMessages = mutableListOf<ChatMessage>()
        chatAdapter = ChatAdapter(chatMessages)

        // Initialize views
        editTextMessage = findViewById(R.id.etMessage)
        buttonSend = findViewById(R.id.btnSendMessage)
        recyclerViewChat = findViewById(R.id.chatRecyclerView)

        recyclerViewChat.adapter = chatAdapter

        // Set up the click listener for the send button
        buttonSend.setOnClickListener {
            sendMessage()
        }
    }

    private fun sendMessage() {
        val userMessage = editTextMessage.text.toString().trim()
        if (userMessage.isNotEmpty()) {
            // Add the user's message to your adapter and update the UI
            chatAdapter.addMessage(ChatMessage(userMessage, isSentByUser = true))

            // Get chatbot response from OpenAI's GPT-3 (replace with your implementation)
            val chatbotResponse = openAiChatbot.getChatbotResponse(userMessage)

            // Add the chatbot's response to your adapter and update the UI
            chatAdapter.addMessage(ChatMessage(chatbotResponse, isSentByUser = false))

            // Notify the adapter that the data set has changed
            chatAdapter.notifyDataSetChanged()

            // Clear the input field
            editTextMessage.setText("")
        }
    }
}
