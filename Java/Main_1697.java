import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697 {
	static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[] cnt = new int[100001];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		while (!queue.isEmpty()) {
			int num = queue.poll();
			if (num == K) {
				System.out.println(cnt[K]);
				break;
			}
			if (2 * num <= 100000) {
				cnt[num * 2] = cnt[num] + 1;
				queue.add(num * 2);
			}
			if (num + 1 <= 100000) {
				cnt[num + 1] = cnt[num] + 1;
				queue.add(num + 1);

			}
			if (num - 1 >= 0) {
				cnt[num - 1] = cnt[num] + 1;
				queue.add(num - 1);
			}
		}

	}
}
