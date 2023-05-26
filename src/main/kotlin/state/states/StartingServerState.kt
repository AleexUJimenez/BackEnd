package states

import state.Server


class StartingServerState(server: Server) : AbstractServerState() {

    init {
        Thread {
            try {
                println("Server Starting")
                Thread.sleep((1000 * 10).toLong())
                if (server.messageProcess.countMessage() >= server.maxRequest) {
                    server.setState(SaturatedServerState(server))
                } else {
                    server.setState(StartServerState(server))
                }
                println("Server Start")
            } catch (e: Exception) {
                println(e.message)
            }
        }.start()
    }

    override fun handleMessage(server: Server?, message: String?) {
        if (server != null && message != null) {
            server.messageProcess.queueMessage(message)
        }
    }
}
