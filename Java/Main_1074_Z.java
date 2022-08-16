import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074_Z {
	static int[][] arr;
	static int N, r, c;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		z(0, 0, (int) Math.pow(2, N),0);
	}

	private static void z(int row, int col, int size,int cnt) {
		if (size == 2) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					if (row+i == r && col+j == c) {
						System.out.println(cnt);
						return;
					}
					cnt++;
				}

			}
			return;
		}
		//다 돌면 시간초과 나니까 r,c의 위치에 따라서 범위 내의 위치만 돌리게
		int half = size / 2;
		
		if (row <= r && r < row + half && col <= c && c < col + half) {
			z(row, col, size / 2,cnt);
		}
		if (row <= r && r < row + half && col + half <= c && c < size + col) {
			z(row, col + size / 2, size / 2,cnt+half*half);
		}
		if (row + half <= r && r < row + size && col <= c && c < col + half) {
			z(row + size / 2, col, size / 2,cnt+half*half*2);
		}
		if (row + half <= r && r < row + size && col + half <= c && c < size + col) {
			z(row + size / 2, col + size / 2, size / 2,cnt+half*half*3);
		}
	}
}
