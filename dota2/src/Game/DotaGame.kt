package Game

import Classes.Team
import Narrator.Narrator
import Narrator.Spanish

class DotaGame<T: Narrator> (narrator: T, radiant: Team, dire: Team): Game<T>(narrator, radiant, dire)