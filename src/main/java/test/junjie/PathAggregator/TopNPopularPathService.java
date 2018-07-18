package test.junjie.PathAggregator;

/**
 * 
 * <p>
 * The interface represent getting the top N path program.
 * </p>
 *
 * @author Jack Sun
 */

public interface TopNPopularPathService {
	/**
	 * initialize the user path mapping by given dataset.
	 *
	 * @param data
	 *            initialize the user path mapping dataset.
	 */
	void setup(String[][] data);

	/**
	 * retrieve the top N navigation path .
	 *
	 * @param topN
	 *            specify the top N path, can not be 0.
	 * @param pathLength
	 *            give the length of the path, should be larger than 0.
	 * @return a list of results. An empty list means no available result can be
	 *         retrieved from the specified range.
	 */
	String[] getTopNPopularPaths(int topN, int pathLength);
	
	/**
	 * retrieve the top N navigation path .
	 *
	 * @param topN
	 *            specify the top N path, can not be 0.
	 * @param pathLength
	 *            give the length of the path, should be larger than 0.
	 * @return a list of results. An empty list means no available result can be
	 *         retrieved from the specified range.
	 */
	//String[] getTopNPopularPathsMultiThread(int topN, int pathLength);
}
