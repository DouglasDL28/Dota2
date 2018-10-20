package Game

import Narrator.Narrator

abstract class Game<T> (val narrator: Narrator<T>, val randiant: Team, val dire: Team) {
    fun welcome (): String {return "Bienvenidos!"}

    fun startGame (): String {return "Ha iniciado la partida. "}

    fun kill (isRandiant: Boolean): String {
        if (isRandiant) {
            return "El equipo Randiant ha conseguido una kill."
        }else {return "El equipo Dire ha conseguido una kill."}
    }

    fun kills (isRadiant: Boolean): String {
        if (isRadiant) {return "El equipo Radiant lleva más de una kill."}
        return "El equipo Dire lleva más de una kill."
    }

    fun killstreak (isRadiant: Boolean): String {
        if (isRadiant) {return "El equipo Radiant lleva 5 kills."}
        return "El equipo Dire lleva 5 kills."
        }

    fun towerKill (isRadiant: Boolean): String {
        if (isRadiant) {return "El equipo Radiant ha eliminado una torre."}
        return "El equipo Dire ha eliminado una torre"
    }

    fun win (isRadiant: Boolean): String {
        if (isRadiant){ return "El equipo Radiant ha ganado la partida!"}
        return "El equipo Dire ha ganado la partida!"
    }
}