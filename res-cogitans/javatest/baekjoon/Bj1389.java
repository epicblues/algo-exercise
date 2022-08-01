package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

/*
백준 1389 케빈 베이컨의 6단계 법칙
Class3, Silver1, Graph, BFS, https://www.acmicpc.net/problem/1389
 */
public class Bj1389 {
	private static int n;
	private static int m;
	private static User[] users;
	private static Map<User, Boolean> visited = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());            //유저의 수
		m = Integer.parseInt(st.nextToken());

		users = new User[n];

		for (int i = 0; i < n; i++) {
			users[i] = new User(i);
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u1 = Integer.parseInt(st.nextToken());
			int u2 = Integer.parseInt(st.nextToken());

			users[u1 - 1].addFriend(users[u2 - 1]);
			users[u2 - 1].addFriend(users[u1 - 1]);
		}

		int min = Integer.MAX_VALUE;
		int minName = Integer.MAX_VALUE;
		for (User user : users) {
			int result = bfs(user);
			visited.clear();
			if (min == result) {
				minName = Math.min(minName, user.name);
				continue;
			}
			if (result < min) {
				min = result;
				minName = user.name;
			}
		}

		System.out.println(minName + 1);
	}

	private static int bfs(User start) {
		Queue<User> toVisit = new LinkedList<>();
		toVisit.offer(start);
		visited.put(start, true);
		int cnt = 0;
		Map<User, Integer> level = new HashMap<>();
		level.put(start, 1);

		while (!toVisit.isEmpty()) {
			User visitNow = toVisit.poll();
			List<User> friendsOfNow = visitNow.friends;
			for (User friend : friendsOfNow) {
				if (visited.getOrDefault(friend, false)) {
					continue;
				}
				level.put(friend, level.get(visitNow) +1);
				cnt+=level.get(visitNow);
				visited.put(friend, true);
				toVisit.offer(friend);
			}
		}

		return cnt;
	}

	private static class User {
		private int name;
		private List<User> friends = new ArrayList<>();

		public User(int name) {
			this.name = name;
		}

		public void addFriend(User user) {
			this.friends.add(user);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (!(o instanceof User))
				return false;

			User user = (User)o;

			return name == user.name;
		}

		@Override
		public int hashCode() {
			return name;
		}
	}
}
