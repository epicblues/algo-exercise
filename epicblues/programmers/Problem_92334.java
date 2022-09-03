import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Problem_92334 {
	public int[] solution(String[] id_list, String[] report, int k) {
		var stringToIntIdMap = new HashMap<String, Integer>();

		for (int i = 0; i < id_list.length; i++) {
			stringToIntIdMap.put(id_list[i], i);

		}

		var reportStorage = new HashSet<String>();

		List<Integer>[] reportStatistic = new List[id_list.length];
		for (int i = 0; i < reportStatistic.length; i++) {
			reportStatistic[i] = new ArrayList<>();
		}
		for (String rep : report) {
			if (!reportStorage.contains(rep)) {
				reportStorage.add(rep);
				var reporter = stringToIntIdMap.get(rep.split(" ")[0]);
				var reported = stringToIntIdMap.get(rep.split(" ")[1]);
				reportStatistic[reported].add(reporter);
			}
		}

		int[] answer = new int[id_list.length];
		for (int reportedId = 0; reportedId < reportStatistic.length; reportedId++) {
			if (reportStatistic[reportedId].size() >= k) {
				for (int reporterId : reportStatistic[reportedId]) {
					answer[reporterId]++;
				}
			}
		}

		return answer;
	}
}
