package state

import states.AbstractServerState
import states.StartServerState
import states.StopServerState

class Server {
    var messageProcess: MessageProcess
    private var state: AbstractServerState? = null

    init {
        messageProcess = MessageProcess(this)
        setState(StopServerState(this))
    }

    val maxRequest: Int
        get() = 5

    fun setState(state: AbstractServerState?) {
        if (this.state is StartServerState && state is StopServerState) {
            println("Server is starting, cannot change state")
            return
        }
        this.state = state
        println("Server change state > ${this.state?.javaClass?.simpleName}")
    }

    fun handleMessage(message: String) {
        state?.handleMessage(this, message)
    }

    fun getState(): AbstractServerState? {
        return state
    }

    fun stopMessageProcess() {
        // Detener el proceso de mensajes
        messageProcess.stop() // Suponiendo que messageProcess es una instancia de la clase MessageProcess y tiene un método stop() para detener el proceso de mensajes
        println("Message process stopped") // Mensaje de confirmación en la consola
    }
}

