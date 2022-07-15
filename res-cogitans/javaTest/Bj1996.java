package javaTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Bj1996 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int workCnt = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());

			printer(workCnt, target, new StringTokenizer(br.readLine(), " "));
		}
	}

	private static void printer(int workCnt, int target, StringTokenizer st) {
		PrinterQueue queue = new PrinterQueue();
		for (int i = 0; i < workCnt; i++) {
			queue.add(new Work(i, Integer.parseInt(st.nextToken())));
		}

		boolean isTargetPrinted = false;
		while (!isTargetPrinted) {
			isTargetPrinted = queue.print(target);
		}
	}

	static class Work {
		final int name;
		final int priority;

		public Work(int name, int priority) {
			this.name = name;
			this.priority = priority;
		}
	}

	static class PrinterQueue {
		private final LinkedList<Work> elements = new LinkedList<>();
		private int printedTime = 1;

		public void add(Work work) {
			elements.add(work);
		}

		public boolean print(int target) {
			if (elements.isEmpty()) {
				return false;
			}

			if (hasMostPriority(elements.get(0))) {
				if (elements.get(0).name == target) {
					System.out.println(printedTime);
					return true;
				} else {
					elements.removeFirst();
					printedTime++;
					return false;
				}
			} else {
				Work toMoved = elements.remove(0);
				elements.offerLast(toMoved);
				return false;
			}
		}

		private boolean hasMostPriority(Work work) {
			for (int i = 1; i < elements.size(); i++) {
				if (work.priority < elements.get(i).priority) {
					return false;
				}
			}
			return true;
		}
	}
}
