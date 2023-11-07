package ItemManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ItemManager {
	private Connection conn;

	public ItemManager(Connection conn) {
		this.conn = conn;
	}

	// Method to Add Item in items table
	public void addItem(Item item) throws SQLException {
		PreparedStatement stmt = conn
				.prepareStatement("INSERT INTO items (id, name, description, category_id) VALUES (?, ?, ?, ?)");
		stmt.setInt(1, item.getId());
		stmt.setString(2, item.getName());
		stmt.setString(3, item.getDescription());
		stmt.setInt(4, item.getCategoryId());
		stmt.executeUpdate();
	}

	// Method to get Items from Category ID
	public List<Item> getItemsByCategory(int categoryId) throws SQLException {
		List<Item> items = new ArrayList<>();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM items WHERE category_id = ?");
		stmt.setInt(1, categoryId);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String description = rs.getString("description");
			Item item = new Item(id, name, description, categoryId);
			items.add(item);
		}
		return items;
	}

	// Method to update Existing Item
	public void updateItem(Item item) throws SQLException {
		PreparedStatement stmt = conn
				.prepareStatement("UPDATE items SET name = ?, description = ?, category_id = ? WHERE id = ?");
		stmt.setString(1, item.getName());
		stmt.setString(2, item.getDescription());
		stmt.setInt(3, item.getCategoryId());
		stmt.setInt(4, item.getId());
		stmt.executeUpdate();
	}

	// Method to Delete Item
	public void deleteItem(int itemId) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("DELETE FROM items WHERE id = ?");
		stmt.setInt(1, itemId);
		stmt.executeUpdate();
	}
// Under Build
//	public List<Item> getAlltotalItems() throws SQLException {
//        List<Item> items = new ArrayList<>();
//        Statement stmt = conn.createStatement();
//        ResultSet rs = stmt.executeQuery("SELECT COUNT(id) FROM items");
//        while (rs.next()) {
//        	int id = rs.getInt("id");
//			
//			Item item = new Item(id);
//            items.add(item);
//        }
//        return items;
//	}
//	public List<Item> getAllItems() throws SQLException {
//		List<Item> items = new ArrayList<>();
//		Statement stmt = conn.createStatement();
//		ResultSet rs = stmt.executeQuery("SELECT * FROM items");
//		while (rs.next()) {
//			int id = rs.getInt("id");
//			String name = rs.getString("name");
//			String description = rs.getString("description");
//			int categoryId = rs.getInt("categoryId");
//			Item item = new Item(id, name, description, categoryId);
//			items.add(item);
//		}
//		return items;
//	}
}