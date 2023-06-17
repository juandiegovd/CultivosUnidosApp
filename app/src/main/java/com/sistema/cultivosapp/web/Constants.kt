package com.sistema.cultivosapp.web

class Constants {
    class ParametrosWeb private constructor() {
        companion object {
            const val IP = "10.0.2.2"
            const val PORT = "8080"
            const val URL = "http://${IP}:${PORT}"
        }
    }

    class ParametrosSesion private constructor(){
        companion object {
            const val LOGIN_CONTEXT = ""
        }
    }
}