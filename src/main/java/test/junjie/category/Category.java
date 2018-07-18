package test.junjie.category;

import java.util.HashMap;
import java.util.Map;

public class Category {
//	Integer id;
	String name;
	String description;
//	String price;
	private Category parentCategory;
	private Map<String, Category> subcategories = new HashMap<String, Category>();

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public String getPrice() {
//		return price;
//	}
//
//	public void setPrice(String price) {
//		this.price = price;
//	}

//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}

	public Map<String, Category> getSubcategories() {
		return subcategories;
	}

	public void setSubcategories(Map<String, Category> subcategories) {
		this.subcategories = subcategories;
	}

}
