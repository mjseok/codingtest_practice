package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1158_요세푸스 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Integer> num = new LinkedList<>();
		for(int i=0;i<N;i++) {
			num.add(i+1);
		}
		sb.append("<");
		int idx=0;
		while(!num.isEmpty()) {
			idx++;
			int tmp = num.poll();
			if(idx==K) {
				if(num.size()!=0) sb.append(tmp).append(", ");
				else sb.append(tmp).append(">");
				idx=0;
			}
			else num.add(tmp);
			
		}
		//sb.append(">");
		System.out.println(sb);
	}
}
