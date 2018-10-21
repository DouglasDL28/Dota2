package Narrator

class English: Narrator
{
    override fun narrate(event: String): String {
        when (event){
            "menu" -> {return """

                MENU:
                1. Kill event.
                2. Tower kill event.

            """.trimIndent()}

            "finalMenu" -> {return """

                MENU:
                1. Kill event.
                2. Tower kill event.
                3. Ancient kill.

            """.trimIndent()}

            "welcome" -> {return """
                Welcome!
                It's your turn to select your heroes.

            """.trimIndent()}

            "starGame" -> {return "START! "}

            "direKill" -> {return "Dire team got a kill!"}

            "radiantKill" -> {return "Radiant team got "}

            "direKills" -> {return "Dire team got "}

            "radiantKills" -> {return "Radiant team has gotten more than 1 kill!"}

            "direKillstreak" -> {return "Dire team has eliminated 5 enemies!"}

            "radiantKillstreak" -> {return "Radiant team has eliminated 5 enemies!"}

            "direTowerKill" -> {return "Dire team has eliminated an opponent's tower! "}

            "radiantTowerKill" -> {return "Radiant team has eliminated an opponent's tower! "}

            "radiantWin" -> {return "Radiant team got the W!"}

            "direWin" -> {return "Dire team got the W!"}
        }
        return " "
    }
}