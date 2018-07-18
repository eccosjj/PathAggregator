package test.junjie.PathAggregator;

/**
 * Hello world!
 *
 */
public class App {

	String[][] data = { { "u1", "a" }, { "u2", "b" }, { "u3", "b" }, { "u1", "a" }, { "u1", "b" }, { "u2", "b" },
			{ "u3", "a" }, { "u3", "b" }, { "u3", "b" }, { "u2", "a" }, { "u2", "b" }, { "u1", "b" }, { "u3", "a" },
			{ "u3", "b" }, { "u3", "b" }, { "u3", "a" }, { "u3", "b" }, { "u3", "b" }, };

	private TopNPopularPathService topNPopularPathService;

	public String[] getTopNPopularPaths(int topN, int pathLength) {
		topNPopularPathService = new TopNPopularPathServiceImpl();
		topNPopularPathService.setup(this.data);
		return topNPopularPathService.getTopNPopularPaths(topN, pathLength);
	}

	public static void main(String[] args) {
		App app = new App();
		String[] result = app.getTopNPopularPaths(2, 3);
		for (String str : result) {
			System.out.println(str);
		}
	}
}
