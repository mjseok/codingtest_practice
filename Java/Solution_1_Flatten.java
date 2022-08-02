package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1_Flatten {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");
			int dump = Integer.parseInt(in.readLine());
			String str = "";
			StringTokenizer st = null;
			int[] box = new int[100];
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			for (int i = 0; i < 100; i++) {
				box[i] = Integer.parseInt(st.nextToken());
			}
			for (int d = 0; d <= dump; d++) {
				int max = box[0];
				int maxIdx = 0;
				int min = box[0];
				int minIdx = 0;				
				for (int i = 0; i < 100; i++) {
					if (max < box[i]) {
						max = box[i];
						maxIdx = i;
					}
					if (min > box[i]) {
						min = box[i];
						minIdx = i;
					}
				}
				if(d!=dump) {
					box[maxIdx] -= 1;
					box[minIdx] += 1;
				}else {
					sb.append(max-min).append("\n");
				}
				
			}
			
		}
		System.out.println(sb);
		
	}
}
