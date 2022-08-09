package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2563 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int size = 10;
		int N = Integer.parseInt(in.readLine());
		String str = "";
		StringTokenizer st = null;
		int[][] paper = new int[100][100];
		int answer=0;
		for (int i = 0; i < N; i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			for (int y = Y; y < Y + 10; y++) {
				for (int x = X; x < X + 10; x++) {
					paper[y][x] = 1;
				}
			}
		}
		for(int x=0;x<100;x++) {
			for(int y=0;y<100;y++) {
				if (paper[y][x]==1) answer++;
			}
		}
		System.out.println(answer);
	}
}
