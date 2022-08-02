package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2805 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		String str = "";
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(in.readLine());
			int[][] farm = new int[N][N];
			for (int i = 0; i < N; i++) {
				str = in.readLine();

				for (int j = 0; j < N; j++) {
					farm[i][j] = str.charAt(j) - '0';
				}

			}
			int profit = 0;
			int tmp = N / 2;// 2
			int j = 0;
			for (int i = 0; i < tmp; i++) {// 01
				for (int k = tmp - i; k <= tmp + i; k++) {
					profit += farm[j][k];

				}
				j++;
				if (j > tmp)
					break;

			}

			for (int i = 0; i < N; i++) {// 2
				profit += farm[tmp][i];

			}
			j = N - 1;
			// 43
			for (int i = 0; i < tmp; i++) {// 01
				for (int k = tmp - i; k <= tmp + i; k++) { // 2 123
					profit += farm[j][k];

				}
				j--;
				if (j < 0)
					break;
			}

			sb.append(profit).append("\n");
		}
		System.out.println(sb);
	}
}
