package ItemManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryManager {
	private Connection conn;

    public CategoryManager(Connection conn) {
        this.conn = conn;
    }

    //Method to Add Category in Categories table
    public void addCategory(Category category) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO categories (id, name) VALUES (?, ?)");
        stmt.setInt(1, category.getId());
        stmt.setString(2, category.getName());
        stmt.executeUpdate();
        getAllCategories();
    }

    //Method to get list of Categories
    public List<Category> getAllCategories() throws SQLException {
        List<Category> categories = new ArrayList<>();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM categories");
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            Category category = new Category(id, name);
            categories.add(category);
        }
        return categories;
    }
}


