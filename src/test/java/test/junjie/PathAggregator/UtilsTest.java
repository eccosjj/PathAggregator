package test.junjie.PathAggregator;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Test;

public class UtilsTest extends AbstractTest {

	@Test
	public void testRetrieveValidUserPath() {
		userPathMapping = Utils.retrieveValidUserPath(data);
		assertTrue(userPathMapping.size() > 0);
		for (Iterator<String> it = userPathMapping.keySet().iterator(); it.hasNext();) {
			String user = it.next();
			System.out.println(user + ":" + userPathMapping.get(user));
		}
	}

	@Test
	public void testRetrievePathCount() {
		userPathMapping = Utils.retrieveValidUserPath(data);
		Map<String, Integer> pathCountMapping = new HashMap<String, Integer>();
		Utils.retrievePathCount(userPathMapping, pathCountMapping, pathLength, true, null);
		assertTrue(pathCountMapping.size() > 0);
		for (Iterator<String> it = pathCountMapping.keySet().iterator(); it.hasNext();) {
			String path = it.next();
			System.out.println(path + ":" + pathCountMapping.get(path));
		}
	}

	@Test
	public void testRetrieveTopNPath() {
		userPathMapping = Utils.retrieveValidUserPath(data);
		pathCountMapping = new HashMap<String, Integer>();
		Utils.retrievePathCount(userPathMapping, pathCountMapping, pathLength, true, null);
		String[] result = Utils.retrieveTopNPath(pathCountMapping, topN);
		assertTrue(result.length > 0);
		for (String str : result) {
			System.out.println(str);
		}
	}

}
