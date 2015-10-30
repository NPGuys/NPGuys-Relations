/*
* NPGuys - Bukkit plugin for better NPC interaction
* Copyright (C) 2014 Adam Gotlib <Goldob>
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 2 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program. If not, see <http://www.gnu.org/licenses/>.
*/

package goldob.npguys.relations;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import goldob.npguys.ElementManager;
import goldob.npguys.NPGuy;
import goldob.npguys.relations.action.DeleteVariable;
import goldob.npguys.relations.action.SetVariable;

public class NPGuysRelations extends JavaPlugin {
	private DatabaseHookup database;
	
	@Override
	public void onEnable() {
		database = new DatabaseHookup(this);
		
		ElementManager.registerAction("SET_RELVAR", SetVariable.class);
		ElementManager.registerAction("DELETE_RELVAR", DeleteVariable.class);
	}
	
	public Relation getRelation(NPGuy npguy, Player player) {
		return new Relation(this, npguy, player);
	}
	
	protected DatabaseHookup getDatabaseHookup() {
		return database;
	}
}
