package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1289 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc);
			char[] bit = in.readLine().toCharArray();
			int len = bit.length;
			char[] init = new char[len];
			int result = 0;
			//초기화된 비트값
			for (int i = 0; i < len; i++) {
				init[i] = '0';
			}
			for (int i = 0; i < len; i++) {
				//지금 메모리랑 초기화된 비트값이 다르면
				if (init[i] != bit[i]) {
					for (int j = i; j < len; j++) {
						init[j] = bit[i];
					}
					//수정한 횟수
					result++;
				}
			}
			sb.append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}
