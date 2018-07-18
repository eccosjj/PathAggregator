package test.junjie.PathAggregator;

import java.util.Map;

import org.junit.After;
import org.junit.Before;

public abstract class AbstractTest {
	String[][] data = { { "u1", "a" }, { "u2", "b" }, { "u3", "b" }, { "u1", "a" }, { "u1", "b" }, { "u2", "b" },
			{ "u3", "a" }, { "u3", "b" }, { "u3", "b" }, { "u2", "a" }, { "u2", "b" }, { "u1", "b" }, { "u3", "a" },
			{ "u3", "b" }, { "u3", "b" }, { "u3", "a" }, { "u3", "b" }, { "u3", "b" }, };

	int pathLength;
	int topN;
	Map<String, String> userPathMapping;
	Map<String, Integer> pathCountMapping;

	@Before
	public void setUp() throws Exception {
		System.out.println("#########################");
		pathLength = 2;
		topN = 2;
	}

	@After
	public void tearDown() throws Exception {
		userPathMapping = null;
		pathCountMapping = null;
	}
}
