package states

import state.Server

class StartServerState(server: Server) : AbstractServerState() {
    init {
        server.messageProcess.start()
    }

    override fun handleMessage(server: Server?, message: String?) {
        if (server != null && message != null) {
            val isSaturated: Boolean = server.messageProcess.queueMessage(message)
            if (!isSaturated) {
                server.setState(SaturatedServerState(server))
            }
        }
    }
}
