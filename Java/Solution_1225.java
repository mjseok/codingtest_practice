package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1225 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < 10; tc++) {
			int T = Integer.parseInt(in.readLine());
			sb.append("#").append(T).append(" ");
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			Queue<Integer> pw = new LinkedList<Integer>();
			for (int i = 0; i < 8; i++) {
				pw.offer(Integer.parseInt(st.nextToken()));
			}
			int cycle = 1;
			int first = pw.poll() - cycle;
			while (first > 0) {
				pw.offer(first);
				cycle++;
				if (cycle == 6)
					cycle = 1;
				first = pw.poll() - cycle;
			}
			pw.offer(0);
			while(!pw.isEmpty()) {
				int tmp=pw.poll();
				sb.append(tmp).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
