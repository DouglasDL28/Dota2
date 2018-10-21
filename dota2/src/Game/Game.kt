package Game

import Classes.Hero
import Classes.Team
import Narrator.Narrator

abstract class Game<T: Narrator> (
        val narrator: T,
        val radiant: Team,
        val dire: Team,
        var radiantKills: Int = 0,
        var direKills: Int = 0,
        var isWinner: Boolean = false)
{

    val heroes = arrayListOf(
            Hero("Abaddon", "Strenght"),
            Hero("Alchemist", "Strenght"),
            Hero("Axe", "Strenght"),
            Hero("Beastmaster", "Strenght"),
            Hero("Chaos knight", "Strenght"),
            Hero("Doom", "Strenght"),
            Hero("Magnus", "Strenght"),
            Hero("Arc Warden", "Agility"),
            Hero("Ember Spirit", "Agility"),
            Hero("Luna", "Agility"),
            Hero("Mirana", "Agility"),
            Hero("Razor", "Agility"),
            Hero("Slark", "Agility"),
            Hero("Spectre", "Agility"),
            Hero("Bane", "Intelligence"),
            Hero("Dazzle", "Intelligence"),
            Hero("Enigma", "Intelligence"),
            Hero("Zeus", "Intelligence"),
            Hero("Lion", "Intelligence"),
            Hero("Pugna", "Intelligence"),
            Hero("Silencer", "Intelligence")
    ) // Lista de heroes.

    fun menu (): String {return narrator.narrate("menu")}

    fun finalMenu (): String {return narrator.narrate("finalMenu")}

    fun welcome (): String {return narrator.narrate("welcome")}

    fun startGame (): String {return narrator.narrate("startGame")}

    fun kill (isRadiant: Boolean): String {
        if (isRadiant) {
            radiantKills += 1
            return narrator.narrate("radiantKill")
        }
        direKills += 1
        return narrator.narrate("direKill")
    }

    fun kills (isRadiant: Boolean, amount: Int): String {
        if (isRadiant) {
            radiantKills += amount
            return narrator.narrate("radiantKills") + amount.toString() + " kills."
        }
        direKills += amount
        return narrator.narrate("direKills") + amount.toString() + " kills."
    }

    fun killstreak (isRadiant: Boolean): String {
        if (isRadiant) {
            radiantKills += 5
            return narrator.narrate("radiantKillstreak")
        }
        direKills += 5
        return narrator.narrate("direKillstreak")
        }

    fun towerKill (isRadiant: Boolean): String {
        if (isRadiant) {
            dire.towerKilled()
            return narrator.narrate("radiantTowerKill")
        }
        radiant.towerKilled()
        return narrator.narrate("direTowerKill")
    }

    fun win (isRadiant: Boolean): String {
        if (isRadiant){
            dire.ancientKilled()
            isWinner = true
            return narrator.narrate("radiantWin")}
        radiant.ancientKilled()
        isWinner = true
        return narrator.narrate("direWin")
    }

    fun printHeroesList(): String {
        var list = " "
        var count = 0
        for (hero in heroes) {
            count += 1
            list += "$count. ${hero.name}: ${hero.type} \n"
        }
        return list
    } //Muestra la lista de heroes disponibles.

    fun findHero (name: String): Hero? {
        for(hero in heroes) {
            if(hero.name.toUpperCase() == name){return hero}
        }
        return null
    } //Busqueda de hero por nombre.

    fun heroPick (hero: Hero?, team: Team): String {
        if(hero != null) {
            heroes.remove(hero)
            team.addHero(hero)
            return "Exito!"
        }
        return "Error!"
    } // Remueve al heroe seleccionado.
}