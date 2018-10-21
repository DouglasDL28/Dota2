package Narrator

class Spanish: Narrator {
    override fun narrate(event: String): String {
        when (event){
            "menu" -> {return """

                MENU:
                1. Ocurrió una kill.
                2. Mataron una torre.

            """.trimIndent()}

            "finalMenu" -> {return """

                MENU:
                1. Ocurrió una kill.
                2. Mataron una torre.
                3. Mataron a un ancient.

            """.trimIndent()}

            "welcome" -> {return """
                Bienvenido!
                Es tu turno de seleccionar a tus heroes.

            """.trimIndent()}

            "starGame" -> {return "Ha iniciado la partida! "}

            "direKill" -> {return "El equipo Dire ha conseguido una kill."}

            "radiantKill" -> {return "El equipo Radiant ha conseguido una kill."}

            "direKills" -> {return "El equipo Dire consiguió "}

            "radiantKills" -> {return "El equipo Radiant consiguió "}

            "direKillstreak" -> {return "El equipo Dire ha eliminado 5 torres!"}

            "radiantKillstreak" -> {return "El equipo Radiant ha eliminado 5 torres!"}

            "direTowerKill" -> {return "El equipo Dire ha eliminado una torre enemiga!"}

            "radiantTowerKill" -> {return "El equipo Radiant ha eliminado una torre enemiga!"}

            "radiantWin" -> {return "El equipo Radiant ha ganado la partida!"}

            "direWin" -> {return "El equipo Dire ha ganado la partida!"}
        }
        return " "
    }
}