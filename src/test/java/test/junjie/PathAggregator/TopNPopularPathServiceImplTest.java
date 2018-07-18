package test.junjie.PathAggregator;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TopNPopularPathServiceImplTest extends AbstractTest {

	TopNPopularPathService topNPopularPathService;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		topNPopularPathService = new TopNPopularPathServiceImpl();
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testGetTopNPopularPaths() {
		topNPopularPathService.setup(data);
		String[] result = topNPopularPathService.getTopNPopularPaths(topN, pathLength);
		assertNotNull(result);
	}

}
