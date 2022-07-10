import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;

public class Problem_1927 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		var answer = new StringBuilder();
		var heap = new Heap(N, (a, b) -> a - b);
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				answer.append(heap.remove()).append("\n");
				continue;
			}
			heap.enqueue(num);
		}
		System.out.println(answer.toString());

	}
}

// 배열 힙
class Heap {

	private final int[] buffer;
	private int size = 0;
	private Comparator<Integer> priorityComparator;

	Heap(int capacity, Comparator<Integer> comparator) {
		this.buffer = new int[capacity];
		this.priorityComparator = comparator;
	}

	public void enqueue(int input) {
		if (size == buffer.length)
			throw new IndexOutOfBoundsException();
		buffer[size++] = input;
		insertionSort(size - 1);
	}

	public int remove() {
		if (size == 0)
			return 0;
		// 배열 끝에 있는 원소 가져오기
		int answer = buffer[0];
		buffer[0] = buffer[size - 1];
		buffer[size - 1] = 0;
		size--;
		removalSort(0);
		return answer;
	}

	private void removalSort(int index) {
		// 자식 노드가 존재하지 않으면 순회 끝
		int firstChildIndex = index * 2 + 1;
		if (firstChildIndex >= size || buffer[firstChildIndex] == 0) {
			return;
		}
		int parentNode = buffer[index];
		int firstChildNode = buffer[firstChildIndex];

		// 일단 두 번째 자식 노드까지 있나 확인
		int secondChildIndex = firstChildIndex + 1;
		int secondChildNode = buffer[secondChildIndex];
		int childToCompareIndex;
		if (secondChildNode > 0) {
			// 두 노드 중 우선순위가 높은 노드 고르기
			if (priorityComparator.compare(firstChildNode, secondChildNode) <= 0) {
				// firstchildnode만 비교
				childToCompareIndex = firstChildIndex;
			} else {
				childToCompareIndex = secondChildIndex;
			}
		} else {
			childToCompareIndex = firstChildIndex;
		}
		int childNode = buffer[childToCompareIndex];

		// 자식 노드와 우선 순위 비교
		boolean isParentHigherPriority = priorityComparator.compare(parentNode, buffer[childToCompareIndex]) <= 0;
		if (isParentHigherPriority) {
			return;
		}
		buffer[index] = childNode;
		buffer[childToCompareIndex] = parentNode;
		removalSort(childToCompareIndex);

	}

	private void insertionSort(int index) {
		// 루프의 끝 index == 1
		if (index == 0) {
			return;
		}

		// 부모 인덱스 및 노드 구하기
		int parentIndex = (index - 1) / 2;
		int parentNode = buffer[parentIndex];
		int childNode = buffer[index];

		// 부모 노드와 비교하기
		boolean isParentHigherPriority = priorityComparator.compare(parentNode, childNode) <= 0;

		// 부모 노드보다 우선순위가 떨어질 경우 자리 고정 및 루프 중단
		if (isParentHigherPriority) {
			return;
		}

		// 부모 노드보다 우선 순위가 높을 경우 부모 노드와 교체 및 루프 계속
		buffer[parentIndex] = childNode;
		buffer[index] = parentNode;
		insertionSort(parentIndex);

	}

}
