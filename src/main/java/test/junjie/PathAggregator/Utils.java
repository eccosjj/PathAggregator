package test.junjie.PathAggregator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 
 * <p>
 * The Util class represent methods of getting Top N paths.
 * </p>
 *
 * @author Jack Sun
 */
public class Utils {

	/**
	 * An inner class which sort the path base on the navigation count.
	 *
	 */
	private static class ValueComparator implements Comparator<Map.Entry<String, Integer>> {
		public int compare(Map.Entry<String, Integer> m, Map.Entry<String, Integer> n) {
			return n.getValue() - m.getValue();
		}
	}

	/**
	 * retrieve the top N navigation path .
	 *
	 * @param topN
	 *            specify the top N path, can not be 0.
	 * @param pathCountMapping
	 *            a collection which store the path and navigation count.
	 * @return a list of results include top N paths.
	 */
	public static String[] retrieveTopNPath(Map<String, Integer> pathCountMapping, int topN) {
		List<String> result = new ArrayList<String>();
		List<Map.Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(pathCountMapping.entrySet());
		Utils.ValueComparator vc = new ValueComparator();
		Collections.sort(list, vc);
		for (int i = 0, n = 0; i < list.size() && n < topN; i++, n++) {
			int count = list.get(i).getValue();
			for (int j = i; j < list.size(); j++) {
				int nextCount = list.get(j).getValue();
				if (count == nextCount) {
					result.add(list.get(j).getKey());
					i = j;
				} else {
					break;
				}
			}
		}
		return result.toArray(new String[result.size()]);
	}

	/**
	 * recursion method, retrieve all navigation path and count aggregation .
	 *
	 * @param userPathMapping
	 *            key-value collection represent user and navigation path.
	 * @param pathCountMapping
	 *            a collection which store the path and navigation count.
	 * @param pathLength
	 *            path length
	 * @param getNewSearchTarget
	 *            a boolean flag which mark if this time is getting new search path
	 *            or not.
	 * @param searchPath
	 *            target search path, if the getNewSearchTarget is true, then this
	 *            value should be ignored.
	 */
	public static void retrievePathCount(Map<String, String> userPathMapping, Map<String, Integer> pathCountMapping,
			int pathLength, boolean getNewSearchTarget, String searchPath) {
		Set<String> users = userPathMapping.keySet();
		int count = 0;
		for (Iterator<String> it = users.iterator(); it.hasNext();) {
			String user = it.next();
			String path = userPathMapping.get(user);
			if (path == null || path.length() < pathLength) {
				continue;
			}
			for (int i = 0; i + pathLength <= path.length(); i++) {
				if (getNewSearchTarget) { // if getNewSearchTarget is true then it's getting the new target then
											// recursive call self again but give getNewSearchTarget false.
					searchPath = path.substring(i, i + pathLength);
					if (pathCountMapping.containsKey(searchPath))
						continue;
					// if getNewSearchTarget is true then
					// recursive call self again but give getNewSearchTarget false.
					Utils.retrievePathCount(userPathMapping, pathCountMapping, pathLength, false, searchPath);
				} else {
					int c = path.indexOf(searchPath, i);
					if (c == -1)
						break;
					count++;
				}
			}
		}
		if (!getNewSearchTarget)
			pathCountMapping.put(searchPath, count);
	}

//	public static void retrievePathCountMultiThread(String user, Map<String, String> userPathMapping,
//			Map<String, Integer> pathCountMapping, String searchPath) {
//		Set<String> users = userPathMapping.keySet();
//		int count = 0;
//		for (Iterator<String> it = users.iterator(); it.hasNext();) {
//			if (it.next().equals(user))
//				continue;
//			String path = userPathMapping.get(user);
//			for (int i = 0; i + pathLength <= path.length(); i++) {
//				if (getNewSearchTarget) { // if getNewSearchTarget is true then it's getting the new target then
//											// recursive call self again but give getNewSearchTarget false.
//					searchPath = path.substring(i, i + pathLength);
//					if (pathCountMapping.containsKey(searchPath))
//						continue;
//					// if getNewSearchTarget is true then
//					// recursive call self again but give getNewSearchTarget false.
//					Utils.retrievePathCount(userPathMapping, pathCountMapping, pathLength, false, searchPath);
//				} else {
//					int c = path.indexOf(searchPath, i);
//					if (c == -1)
//						break;
//					count++;
//				}
//			}
//		}
//		if (!getNewSearchTarget)
//			pathCountMapping.put(searchPath, count);
//	}

	/**
	 * retrieve all navigation user and navigation path .
	 *
	 * @param data
	 *            a collection which store user and path mapping.
	 * @return a key-value collection include the user and path with specific sort.
	 */
	public static Map<String, String> retrieveValidUserPath(String[][] data) {
		if (data == null || data.length == 0)
			return null;
		Map<String, String> userPath = new HashMap<String, String>();
		for (int i = 0; i < data.length; i++) {
			try {
				String path = userPath.containsKey(data[i][0]) ? userPath.get(data[i][0]) + data[i][1] : data[i][1];
				userPath.put(data[i][0], path);
			} catch (IndexOutOfBoundsException e) {
				System.out.println("User:" + data[i] + " has invalid path");
			}
		}
		return userPath;
	}
}
