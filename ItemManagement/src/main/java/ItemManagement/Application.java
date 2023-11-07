package ItemManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		try {
			Service service = new Service();
			// Establish database connection
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/itemmanagement", "postgres",
					"Faizan007");

			// Create CategoryManager and ItemManager objects
			CategoryManager categoryManager = new CategoryManager(conn);
			ItemManager itemManager = new ItemManager(conn);
			Scanner sc = new Scanner(System.in);
			
			while (true) {
				System.out.println("Enter 1 to add new Category");
				System.out.println("Enter 2 to add Item and associate it with Category iD");
				System.out.println("Enter 3 to get List of Category");
				System.out.println("Enter 4 to get Item associated with Category id");
				System.out.println("Enter 5 to calulate Statictical Data");
				int key = Integer.parseInt(sc.nextLine());
				switch (key) {
				case 1:
					//to add new Category
					service.addNewCatgory();
					break;
					
				case 2:
					//to add Item and associate it with Category iD
					service.addItemByCategoryId();
					break;
					
				case 3:
					//to get List of Category
					service.getAllCategories();
					break;
					
				case 4:
					//to get Item associated with Category id
					service.getAllItemtoCategory();
					break;
					
				case 5:
					//to calulate Statictical Data
					System.out.println("The Function in under build, Sorry for inconvenience");
					//service.statisticalCalculations();
					break;
					
				case 6:
					// Close database connection
					conn.close();
					System.out.println("Connection Close : Thank You for using");
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}