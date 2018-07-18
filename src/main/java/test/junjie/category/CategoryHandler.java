package test.junjie.category;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 
 * <p>
 * The the class represent category and product
 * </p>
 *
 * @author Jack Sun
 */
public class CategoryHandler {
	/**
	 * retrieve the top N navigation path .
	 *
	 * @param category
	 *            the root category which will be retrived
	 */
	public void printCategories(Category category) {
		print(category);
		Map<String, Category> subCategories = category.getSubcategories();
		Set<String> subkeys = subCategories.keySet();
		for (Iterator<String> it = subkeys.iterator(); it.hasNext();) {
			String subkey = it.next();
			Category subCategory = subCategories.get(subkey);
			printCategories(subCategory);
		}
	}

	/**
	 * print the current category's name.
	 *
	 */
	private void print(Category category) {
		System.out.println(category.getName());
	}

	/**
	 * print a product's entire path
	 */
	public void printPath(Category root, Category category) {
		String name = category.getName();
		Map<String, Category> subCategories = root.getSubcategories();
		Set<String> subkeys = subCategories.keySet();
		for (Iterator<String> it = subkeys.iterator(); it.hasNext();) {
			String subkey = it.next();
			if (subkey.endsWith("/" + name)) {
				System.out.println(subkey);
				break;
			}
		}
	}

	/**
	 * print a product's entire path
	 */

	public void printPath2(String path, Category root, Category c) {
		Map<String, Category> subCategories = root.getSubcategories();
		Set<String> subkeys = subCategories.keySet();
		for (Iterator<String> it = subkeys.iterator(); it.hasNext();) {
			String subkey = it.next();
			Category cat = subCategories.get(subkey);
			String newPath = path + "/" + cat.getName();
			if (cat instanceof Product && cat.getName().equals(c.getName())) {
				System.out.println(newPath);
				break;
			} else {
				this.printPath2(newPath, cat, c);
			}
		}
	}

}
