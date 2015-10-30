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

import java.sql.SQLException;

import org.bukkit.entity.Player;

import goldob.npguys.NPGuy;

public class Relation {
	private NPGuysRelations plugin;
	private NPGuy npguy;
	private Player player;
	
	protected Relation(NPGuysRelations plugin, NPGuy npguy, Player player) {
		this.plugin = plugin;
		this.npguy = npguy;
		this.player = player;
	}
	
	public Object readVariable(String name) throws SQLException {
		return plugin.getDatabaseHookup().readVariable(this, name);
	}
	
	public void writeVariable(String name,  Object value) throws SQLException {
		plugin.getDatabaseHookup().writeVariable(this, name, value);
	}
	
	public void deleteVariable(String name) throws SQLException {
		plugin.getDatabaseHookup().deleteVariable(this, name);
	}
	
	public NPGuy getNPGuy() {
		return npguy;
	}
	
	public Player getPlayer() {
		return player;
	}
}
