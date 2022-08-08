package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_9229_한빈이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str="";
		StringTokenizer st = null;
		int T = Integer.parseInt(in.readLine());
		int[] snacks;
		for(int tc=1;tc<=T;tc++) {
			int max = Integer.MIN_VALUE;
			sb.append("#").append(tc).append(" ");
			str=in.readLine();
			st = new StringTokenizer(str," ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			snacks =  new int[N];
			
			str=in.readLine();
			st = new StringTokenizer(str," ");

			for(int i=0;i<N;i++) {
				snacks[i]=Integer.parseInt(st.nextToken());
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(i!=j) {
						int tmp = snacks[i]+snacks[j];
						if(tmp<=M) {
							max = max < tmp ? tmp : max; 
						}

					}
				}
			}
			if(max == Integer.MIN_VALUE) max=-1;
			sb.append(max).append("\n");
			
		}
		System.out.println(sb);
	}
}
