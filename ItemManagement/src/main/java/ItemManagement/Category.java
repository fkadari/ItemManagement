package ItemManagement;

public class Category {
	private int id;
	private String name;
	
	//Constructor
	public Category(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	//Getters and Setters for the class
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
