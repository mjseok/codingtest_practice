import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_10971_외판원순회2 {
	static int N;
	static int[][] weight;
	static boolean[] isVisit;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		StringTokenizer st = null;

		N = Integer.parseInt(in.readLine());
		weight = new int[N][N];
		isVisit = new boolean[N];
		for (int i = 0; i < N; i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			for (int j = 0; j < N; j++) {
				weight[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0, 0);

		System.out.println(min);
	}

	private static void dfs(int start, int cur, int sum) {// 시작점, 현재 위치
		isVisit[cur] = true;
		boolean allVisit = true;
		for (int i = 0; i < N; i++) {
			if (!isVisit[i]) {
				allVisit = false;
				break;
			}
		}
		if (allVisit == true && weight[cur][start] != 0) {
			min = min > sum + weight[cur][0] ? sum + weight[cur][0] : min;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (weight[cur][i] != 0 && !isVisit[i]) {
				isVisit[i] = true;
				dfs(start, i, sum + weight[cur][i]);
				isVisit[i] = false;
			}
		}

	}

}
