package com.example.mindy_1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
class ChatAdapter(private val messageList: MutableList<ChatMessage>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val USER_MESSAGE = 1
    private val BOT_MESSAGE = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutRes = when (viewType) {
            USER_MESSAGE -> R.layout.item_kanan
            BOT_MESSAGE -> R.layout.item_kiri
            else -> throw IllegalArgumentException("Invalid view type")
        }
        val view = LayoutInflater.from(parent.context).inflate(layoutRes, parent, false)
        return when (viewType) {
            USER_MESSAGE -> UserMessageViewHolder(view)
            BOT_MESSAGE -> BotMessageViewHolder(view)
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemCount(): Int {
        return messageList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val message = messageList[position]
        when (holder.itemViewType) {
            USER_MESSAGE -> {
                val userViewHolder = holder as UserMessageViewHolder
                userViewHolder.bindUserMessage(message)
            }
            BOT_MESSAGE -> {
                val botViewHolder = holder as BotMessageViewHolder
                botViewHolder.bindBotMessage(message)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (messageList[position].isSentByUser) USER_MESSAGE else BOT_MESSAGE
    }

    inner class UserMessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val userMessageTextView: TextView = itemView.findViewById(R.id.tvMessage)

        fun bindUserMessage(message: ChatMessage) {
            userMessageTextView.text = message.text
        }
    }

    fun addMessage(message: ChatMessage) {
        messageList.add(message)
        notifyItemInserted(messageList.size - 1)
    }

    inner class BotMessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val botMessageTextView: TextView = itemView.findViewById(R.id.tvMessageBot)

        fun bindBotMessage(message: ChatMessage) {
            botMessageTextView.text = message.text
        }
    }
}
