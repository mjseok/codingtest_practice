import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697_숨바꼭질 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str ="";
		str=in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] cnt = new int[100001];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		//0에서 출발할 때
		cnt[N]=1;
		while (!queue.isEmpty()) {
			int num = queue.poll();
			if (num == K) {
				break;
			}
			//방문했던 곳 또 방문하면 최소가 아니니까
			if (2 * num <= 100000 && cnt[num * 2] == 0) {
				cnt[num * 2] = cnt[num] + 1;
				queue.add(num * 2);
			}
			if (num + 1 <= 100000 && cnt[num + 1] == 0) {
				cnt[num + 1] = cnt[num] + 1;
				queue.add(num + 1);

			}
			if (num - 1 >= 0 && cnt[num - 1] == 0) {
				cnt[num - 1] = cnt[num] + 1;
				queue.add(num - 1);
			}
			//cnt[num]=1;
		}
		System.out.println(cnt[K]-1);

	}
}
