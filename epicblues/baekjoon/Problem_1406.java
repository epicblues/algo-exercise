import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem_1406 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		var input = br.readLine();
		var buffer = new CursorLinkedList<Character>();
		for (int i = 0; i < input.length(); i++) {
			buffer.append(input.charAt(i));
		}
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			var commands = br.readLine();
			var front = commands.charAt(0);
			if (front == 'L') {
				buffer.left();
				continue;
			}
			if (front == 'D') {
				buffer.right();
				continue;
			}

			if (front == 'B') {
				buffer.delete();
				continue;
			}

			if (front == 'P') {
				buffer.insertPrevCursor(commands.split(" ")[1].charAt(0));
			}

		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while (buffer.head != null) {
			bw.append(buffer.head.data);
			buffer.head = buffer.head.next;
		}

		bw.flush();
	}

	static class CursorLinkedList<T> {
		Node<T> cursor = new Node<>(null);
		Node<T> head;

		void append(T data) {
			if (head == null) {
				head = new Node<>(data);
				cursor.prev = head;
				return;
			}

			var newNode = new Node<T>(data);
			cursor.prev.next = newNode;
			newNode.prev = cursor.prev;
			cursor.prev = newNode;
			cursor.next = null;
		}

		void delete() {

			if (cursor.prev == null) {
				return;
			}

			var target = cursor.prev;

			if (target.prev != null) {
				target.prev.next = target.next;
			}

			if (target.next != null) {
				target.next.prev = target.prev;
			}
			cursor.prev = target.prev;
			cursor.next = target.next;
			if (target == head) {
				head = cursor.next;
			}

		}

		void insertPrevCursor(T data) {
			var target = new Node<>(data);

			if (cursor.prev != null) {
				cursor.prev.next = target;
			} else {
				// 왼쪽 끝자락에 있었다는 것.
				head = target;
			}
			target.prev = cursor.prev;
			cursor.prev = target;
			if (cursor.next != null) {
				cursor.next.prev = target;
			}
			target.next = cursor.next;
		}

		void left() {
			var prev = cursor.prev;
			if (prev == null) {
				return;
			}
			cursor.prev = prev.prev;
			cursor.next = prev;
		}

		void right() {
			var next = cursor.next;
			if (next == null) {
				return;
			}

			cursor.next = next.next;
			cursor.prev = next;
		}

		private static class Node<T> {
			T data;
			Node<T> next;
			Node<T> prev;

			Node(T data) {
				this.data = data;
				this.next = null;
				this.prev = null;
			}
		}

	}

}
