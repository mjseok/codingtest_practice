
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17406 {
	static int N, M, K;
	static int[][] rotation;
	static int[][] res, arr;
	static boolean[] isSelected;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		str = in.readLine();
		st = new StringTokenizer(str, " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		rotation = new int[K][3];
		res = new int[K][3];
		isSelected = new boolean[K];
		for (int i = 0; i < N; i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < K; i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			for (int j = 0; j < 3; j++) {
				rotation[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		perm(0);
		System.out.println(min);

	}

	private static void perm(int cnt) {
		if (cnt == K) {
			int[][] copyArr = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					copyArr[i][j] = arr[i][j];
				}
			}
			for (int i = 0; i < res.length; i++) {
				// 회전하는거 넣기
				rotation(res[i][0], res[i][1], res[i][2], copyArr);
			}
			min = min >calc(copyArr) ? calc(copyArr):min;
			return;
		}
		for (int i = 0; i < K; i++) {
			if (isSelected[i])
				continue;
			res[cnt][0] = rotation[i][0];
			res[cnt][1] = rotation[i][1];
			res[cnt][2] = rotation[i][2];
			isSelected[i] = true;
			perm(cnt + 1);
			isSelected[i] = false;
		}

	}

	private static void rotation(int r, int c, int s, int[][] arr) {
		int x1 = r - s - 1;
		int y1 = c - s - 1;
		int x2 = r + s - 1;
		int y2 = c + s - 1;
		
		for (int i = 0; i < s; i++) {
			int tmp = arr[x1 + i][y1 + i];
			// 왼
			for (int j = x1 + i; j < x2 - i; j++) {
				arr[j][y1+i] = arr[j + 1][y1+i];
			}
			// 밑
			for (int j = y1 + i; j < y2 - i; j++) {
				arr[x2-i][j] = arr[x2-i][j + 1];
			}
			// 오
			for (int j = x2 - i; j > x1 + i; j--) {
				arr[j][y2-i] = arr[j - 1][y2-i];
			}
			//위
			for (int j = y2 - i; j > y1 + i; j--) {
				arr[x1+i][j] = arr[x1+i][j - 1];
			}
			arr[x1 + i][y1 + i + 1] = tmp;
		}

	}

	private static int calc(int[][] arr) {
		int[] sum = new int[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				//System.out.print(arr[i][j]);
				sum[i] += arr[i][j];
			}
			//System.out.println();
		}
		Arrays.sort(sum);
		return sum[0];
	}
}
