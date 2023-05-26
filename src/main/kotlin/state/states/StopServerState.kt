package states

import states.AbstractServerState
import state.Server

class StopServerState(server: Server) : AbstractServerState() {
    init {
        server.stopMessageProcess()
    }

    override fun handleMessage(server: Server?, message: String?) {
        println("The server is stopped")
    }
}