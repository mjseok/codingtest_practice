package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16926 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = "";
		str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int line = Math.min(N, M) / 2;
		// 회전하는 수만큼 돌려
		for (int r = 0; r < R; r++) {
			for (int i = 0; i < line; i++) {
				int tmp = arr[i][i];
				// x-1(위)
				for (int j = i + 1; j <= M - i - 1; j++) {
					arr[i][j - 1] = arr[i][j];
				}
				// y-1(오른)
				for (int j = i + 1; j <= N - 1 - i; j++) {
					arr[j - 1][M - i - 1] = arr[j][M - 1 - i];
				}
				//x+1(아래)
				for (int j = M - 1 - i - 1; j >= i; j--) {
					arr[N - i - 1][j + 1] = arr[N - i - 1][j];
				}
				//y+1(왼)
				for (int j = N - 1 - i - 1; j >= i; j--) {
					arr[j + 1][i] = arr[j][i];
				}
				arr[i+1][i]=tmp;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]).append(" ");

			}
			sb.append("\n");

		}
		System.out.println(sb);

	}
}
