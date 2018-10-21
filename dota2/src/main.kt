import Classes.*
import Narrator.* import Game.*
import java.util.*

fun pickLanguage (pick: Int): Narrator {
    if (pick == 1) {
        val narrator = Spanish()
        return narrator
    }
    val narrator = English()
    return narrator
}

val towers = arrayListOf(Tower(), Tower(), Tower(), Tower(), Tower(), Tower())

fun main (args: Array<String>) {
    val dire = Team(towers)
    val radiant = Team(towers)

    println("""
        PICK A LANGUAGE:
        1. Spanish
        2. English

    """.trimIndent()) //Menu de idioma.

    val pick = readLine()!!.toInt()

    val dota2 = DotaGame(pickLanguage(pick), radiant, dire)

    do {
        println("RADIANT: ")
        println(dota2.welcome()) //Mensaje de bienvenida.
        for(n in 1..5) {
            println("Hero $n:")
            println(dota2.printHeroesList())
            print("Select a hero (by name): ")

            val name = readLine()!!.toUpperCase()
            dota2.heroPick(dota2.findHero(name), radiant)
        } //Selección de heroes

        println("DIRE: ")
        dota2.welcome()
        for(n in 1..5) {
            println("Hero $n:")
            println(dota2.printHeroesList())

            print("Select a hero (by name): ")

            val name = readLine()!!.toUpperCase()
            dota2.heroPick(dota2.findHero(name), dire)
        } //Selección de heroes

        println(dota2.startGame())

        while (dire.towersCount() != 0 && radiant.towersCount() != 0) {
            println(dota2.menu())
            val option = readLine()!!.toInt()

            when (option) {
                1 -> {
                    println("Fue el equipo Radiant? (True / False)")
                    val isRadiant = readLine()!!.toLowerCase().toBoolean()

                    println("Cuantas kills? (1-5)")
                    val killCount = readLine()!!.toInt()

                    if(killCount == 1) {
                        dota2.kill(isRadiant)
                    } else if (killCount == 5) {
                        dota2.killstreak(isRadiant)
                    } else {
                        dota2.kills(isRadiant, killCount)
                    }
                } // Hubo muertes.

                2 -> {
                    println("Fue el equipo Radiant? (True / False)")
                    val isRadiant = readLine()!!.toLowerCase().toBoolean()
                    dota2.towerKill(isRadiant)
                } //Murió una torre.
            }
        }

        do{
            println(dota2.finalMenu())
            val option = readLine()!!.toInt()
             when (option) {
                 1 -> {
                     println("Fue el equipo Radiant? (True / False)")
                     val isRadiant = readLine()!!.toLowerCase().toBoolean()

                     println("Cuantas kills? (1-5)")
                     val killCount = readLine()!!.toInt()

                     if(killCount == 1) {
                         dota2.kill(isRadiant)
                     } else if (killCount == 5) {
                         dota2.killstreak(isRadiant)
                     } else {
                         dota2.kills(isRadiant, killCount)
                     }
                 } //Ocurrieron muertes.

                 2 -> {
                     println("Fue el equipo Radiant? (True / False)")
                     val isRadiant = readLine()!!.toLowerCase().toBoolean()
                     println(dota2.towerKill(isRadiant))
                 } //Mataron torres.

                 3 -> {
                     println("Fue el equipo Radiant? (True / False)")
                     val isRadiant = readLine()!!.toLowerCase().toBoolean()
                     println(dota2.win(isRadiant))
                     dota2.isWinner = true} // Matan ancient.
             }
        }while (!dota2.isWinner)



    }while(!dota2.isWinner)
}