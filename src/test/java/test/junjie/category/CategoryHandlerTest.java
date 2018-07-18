package test.junjie.category;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CategoryHandlerTest {

	Category category;
	CategoryHandler chandler;

	@Before
	public void setUp() throws Exception {
		this.category = this.initialSubCategories();
		chandler = new CategoryHandler();
	}

	private Category initialSubCategories() {
		Category category = new Category();
		category.setName("root");
		// category.setPrice("price");
		category.setDescription("description");
		Map<String, Category> subc1 = new HashMap<String, Category>();
		for (int i = 0; i < 3; i++) {
			Category c1 = new Category();
			c1.setName("c" + i);
			// c1.setPrice("price" + i);
			c1.setDescription("description" + i);
			Map<String, Category> subc2 = new HashMap<String, Category>();
			for (int j = 0; j < 3; j++) {
				Product c2 = new Product();
				c2.setName("d" + j);
				c2.setPrice("price" + j);
				c2.setDescription("description" + j);
				subc2.put(c2.getName(), c2);
			}
			c1.setSubcategories(subc2);
			subc1.put(c1.getName(), c1);
		}
		category.setSubcategories(subc1);
		return category;
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testPrintCategories() {
		chandler.printCategories(category);
	}

	// @Test
	// public void testPrintPath() {
	// Category c = new Category();
	// c.setName("d2");
	// chandler.printPath(category, c);
	// }

	@Test
	public void testPrintPath2() {
		Category c = new Product();
		c.setName("d2");
		chandler.printPath2(category.getName(), category, c);
	}

}
