package Classes
import java.util.*
import kotlin.collections.ArrayList

class Team (val towers: ArrayList<Tower>)
{
    val ancient: Ancient = Ancient()
    val heroes: ArrayList<Hero> = ArrayList()

    fun towerKilled (){
        do {
            val ranNum = Random().nextInt(towers.size)
            val check = towers[ranNum].isDead
            towers[ranNum].isDead = true
        } while (check)
    }

    fun towersCount (): Int {
        var count: Int = 6
        for (tower in this.towers) {
           if (tower.isDead) {count -= 1}
        }
        return count
    }

    fun ancientKilled (){
        ancient.isDead = true
    }

    fun addHero (hero: Hero) {
        heroes.add(hero)
    }

}
