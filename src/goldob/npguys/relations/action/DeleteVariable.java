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

package goldob.npguys.relations.action;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

import goldob.npguys.action.Action;
import goldob.npguys.exception.FailedToLoadException;
import goldob.npguys.exception.InvalidCommandException;

public class DeleteVariable extends Action {

	public DeleteVariable(String type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fromCommand(String[] arg0) throws InvalidCommandException {
		// TODO Auto-generated method stub
	}

	@Override
	public String getData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void load(ConfigurationSection config) throws FailedToLoadException {
		// TODO Auto-generated method stub
	}

	@Override
	public void perform(Player player) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void save(ConfigurationSection arg0) {
		// TODO Auto-generated method stub
	}
}
