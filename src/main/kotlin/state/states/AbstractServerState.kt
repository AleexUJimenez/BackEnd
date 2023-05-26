package states

import state.Server

abstract class AbstractServerState {
    abstract fun handleMessage(
        server: Server?, message: String?
    )
}

