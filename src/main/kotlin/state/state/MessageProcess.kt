package state

import java.util.*

class MessageProcess(server: Server) {
    private var sendThread: Thread? = null
    private val server: Server
    private val messageQueue: Queue<String> = LinkedList()

    init {
        this.server = server
    }

    fun queueMessage(message: String): Boolean {
        if (messageQueue.size >= server.maxRequest) {
            println("Requests reached maximum (${messageQueue.size})")
            return false
        }
        messageQueue.add(message)
        println("Queue message (${messageQueue.size})")
        return true
    }

    fun countMessage(): Int {
        return messageQueue.size
    }

    fun start() {
        sendThread = Thread {
            try {
                while (true) {
                    Thread.sleep((1000 * 10).toLong())
                    if (!messageQueue.isEmpty()) {
                        val message = messageQueue.poll()
                        println("Message process > $message (${messageQueue.size})")
                    }
                }
            } catch (ex: InterruptedException) {
                println(ex.message)
            }
        }
        sendThread!!.start()
    }

    fun stop() {
        sendThread?.interrupt()
        sendThread = null
    }
}

