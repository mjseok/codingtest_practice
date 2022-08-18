import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1987 {
	static int R, C;
	static char[][] board;
	static boolean[] isVisit;
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		StringTokenizer st = null;
		str = in.readLine();
		st = new StringTokenizer(str, " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		isVisit = new boolean[26];
		for (int i = 0; i < R; i++) {
			str = in.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = str.charAt(j);
			}
		}
		dfs(0, 0, 0);
		System.out.println(ans);

	}

	private static void dfs(int r, int c, int cnt) {
		if (isVisit[board[r][c] - 'A']) {
			ans = Math.max(ans, cnt);
			return;
		}
		isVisit[board[r][c] - 'A'] = true;
		int[] dy = new int[] { 1, -1, 0, 0 };
		int[] dx = new int[] { 0, 0, 1, -1 };
		for (int i = 0; i < 4; i++) {
			int nC = c + dx[i];
			int nR = r + dy[i];
			if (nC >= 0 && nC < C && nR >= 0 && nR < R) {				
				dfs(nR, nC, cnt + 1);
			}
		}
		isVisit[board[r][c] - 'A'] = false;
	}
}
