package ItemManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Service {
	Connection conn;
	int cateId;

	// Method to add Category using CLI
	public void addNewCatgory() {

		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/itemmanagement", "postgres",
					"Faizan007");

			CategoryManager categoryManager = new CategoryManager(conn);
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Category ID");
			cateId = Integer.parseInt(sc.nextLine());

			System.out.println("Enter Category Name");
			String cateName = sc.nextLine();
			Category category = new Category(cateId, cateName);
			categoryManager.addCategory(category);
			System.out.println("Category Added Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Method to add item by category_id using CLI
	public void addItemByCategoryId() {
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/itemmanagement", "postgres",
					"Faizan007");
			Scanner sc = new Scanner(System.in);
			ItemManager itemManager = new ItemManager(conn);
			System.out.println("Enter Item ID");
			int id = Integer.parseInt(sc.nextLine());
			System.out.println("Enter Item Name");
			String name = sc.nextLine();
			System.out.println("Enter Item Description");
			String desc = sc.nextLine();
			System.out.println("Enter Category ID");
			cateId = Integer.parseInt(sc.nextLine());
			Item item = new Item(id, name, desc, cateId);
			itemManager.addItem(item);
			System.out.println("Item Added Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Method to get list Category using CLI
	public void getAllCategories() {
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/itemmanagement", "postgres",
					"Faizan007");

			Scanner sc = new Scanner(System.in);
			CategoryManager categoryManager = new CategoryManager(conn);
			List<Category> category = categoryManager.getAllCategories();

			for (Category c : category) {
				System.out.println(c.getId() + " " + c.getName());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Method to get all item specific to category ID
	public void getAllItemtoCategory() {
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/itemmanagement", "postgres",
					"Faizan007");

			Scanner sc = new Scanner(System.in);
			ItemManager itemManager = new ItemManager(conn);
			System.out.println("Enter Category ID to get list of Items");
			cateId = Integer.parseInt(sc.nextLine());
			List<Item> items = itemManager.getItemsByCategory(cateId);
			for (Item i : items) {
				System.out.println(i.getId() + " " + i.getName() + " " + i.getDescription() + " " + i.getCategoryId());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// Under Build
//	public void statisticalCalculations() {
//		try {
//			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/itemmanagement", "postgres",
//					"Faizan007");
//
//			ItemManager itemManager = new ItemManager(conn);
//			List<Item> items = itemManager.getAllItems();
//			for (Item c : items) {
//				System.out.println(c.getId());
//			}
//			Iterator<Item> iterator = items.iterator();
//			int count = 0;
//			while (iterator.hasNext()) {
//				Item item = iterator.next();
//				int id = item.getId();
//
//				count++;
//			}
//			System.out.println(count);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
}
