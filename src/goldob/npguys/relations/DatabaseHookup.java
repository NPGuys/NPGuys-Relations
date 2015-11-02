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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseHookup {
	private NPGuysRelations plugin;
	
	private String DB_HOST;
	private String DB_USER;
	private String DB_PASS;
	
	public DatabaseHookup(NPGuysRelations plugin) {
		this.plugin = plugin;
		DB_HOST = plugin.getConfig().getString("host");
		DB_USER = plugin.getConfig().getString("login");
		DB_PASS = plugin.getConfig().getString("password");
		
		// TODO Initialize
	}
	
	private void initialize() throws SQLException {
		// TODO
		String query = "CREATE TABLE Relations ("
				+ "NPGuy VARCHAR,"
				+ "Player VARCHAR,"
				+ "Variable VARCHAR,"
				+ "Value VARCHAR,"
				+ "PRIMARY KEY(NPGuy, Player, Variable)"
				+ ");";
		getSQLConnection().createStatement().execute(query);
	}
	
	public Object readVariable(Relation relation, String variableName) throws SQLException {
		String query = "SELECT Value FROM Relations WHERE NPGuy = ? AND Player = ? AND Variable = ?";
		
		PreparedStatement statement = getSQLConnection().prepareStatement(query);
		statement.setString(1, relation.getNPGuy().getUID());
		statement.setString(2, relation.getPlayer().getName());
		statement.setString(3, variableName);
		
		ResultSet result = statement.executeQuery();
		//result.get
		return null;
	}
	
	public void writeVariable(Relation relation, String variableName, Object value) throws SQLException {
		String query = "INSERT INTO Relations (NPGuy, Player, Variable, Value) Values (?, ?, ?, ?)";
		
		PreparedStatement statement = getSQLConnection().prepareStatement(query);
		statement.setString(1, relation.getNPGuy().getUID());
		statement.setString(2, relation.getPlayer().getName());
		statement.setString(3, variableName);
		
		statement.execute();
		// TODO
	}
	
	public void deleteVariable(Relation relation, String variableName) throws SQLException {
		String query = "INSERT FROM Relations WHERE NPGuy = ? AND Player = ? AND Variable = ?";
		
		PreparedStatement statement = getSQLConnection().prepareStatement(query);
		statement.setString(1, relation.getNPGuy().getUID());
		statement.setString(2, relation.getPlayer().getName());
		statement.setString(3, variableName);
		
		statement.execute();
		// TODO
	}
	
	private Connection getSQLConnection() throws SQLException {
		return DriverManager.getConnection(DB_HOST, DB_USER, DB_PASS);
	}
}
