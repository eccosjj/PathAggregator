package test.junjie.PathAggregator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The implementation class for getting the top N path program.
 * 
 * @author Jack Sun
 */

public class TopNPopularPathServiceImpl implements TopNPopularPathService {

	private String[][] data;
	Map<String, Integer> pathCountMapping;

	public void setup(String[][] data) {
		this.data = data;
	}

	public String[] getTopNPopularPaths(int topN, int pathLength) {
		String[] topNPath = null;
		Map<String, String> userPathMapping = Utils.retrieveValidUserPath(data);
		if (userPathMapping != null) {
			this.pathCountMapping = new HashMap<String, Integer>();
			Utils.retrievePathCount(userPathMapping, pathCountMapping, pathLength, true, null);
			topNPath = Utils.retrieveTopNPath(pathCountMapping, topN);
		}
		return topNPath;
	}

//	public String[] getTopNPopularPathsMultiThread(int topN, int pathLength) {
//		String[] topNPath = null;
//		Map<String, String> userPathMapping = Utils.retrieveValidUserPath(data);
//		if (userPathMapping != null) {
//			this.pathCountMapping = new HashMap<String, Integer>();
//			ExecutorService exec = Executors.newFixedThreadPool(userPathMapping.size());
//			Set<String> users = userPathMapping.keySet();
//			for (Iterator<String> it = users.iterator(); it.hasNext();) {
//				String user = it.next();
//				String path = userPathMapping.get(user);
//				new TopNExecutor(userPathMapping, path, pathLength, user).start();
//			}
//			topNPath = Utils.retrieveTopNPath(pathCountMapping, topN);
//
//		}
//		return topNPath;
//	}
//
//	class TopNExecutor extends Thread {
//
//		private String path;
//		private String user;
//		private int pathLength;
//		private Map<String, Integer> pathCountMapping;
//		private Map<String, String> userPathMapping;
//
//		public TopNExecutor(Map<String, String> userPathMapping, String path, int pathLength, String user) {
//			this.path = path;
//			this.user = user;
//			this.pathLength = pathLength;
//			this.userPathMapping = userPathMapping;
//		}
//
//		public void run() {
//			if (this.path != null && !this.path.equals("") && this.pathLength != 0 && this.path.length() > pathLength) {
//				this.pathCountMapping = new HashMap<String, Integer>();
//				addToPathCount(pathCountMapping);
//			}
//
//		}
//	}
//
//	protected synchronized void addToPathCount(Map<String, Integer> pathCountMappingFrom1Thread) {
//		if (pathCountMappingFrom1Thread != null && pathCountMappingFrom1Thread.size() > 0) {
//			Set<String> paths = pathCountMappingFrom1Thread.keySet();
//			for (Iterator<String> it = paths.iterator(); it.hasNext();) {
//				String path = it.next();
//				if (this.pathCountMapping.containsKey(path)) {
//					this.pathCountMapping.put(path,
//							this.pathCountMapping.get(path) + pathCountMappingFrom1Thread.get(path));
//				} else {
//					this.pathCountMapping.put(path, pathCountMappingFrom1Thread.get(path));
//				}
//
//			}
//		}
//	}

}
