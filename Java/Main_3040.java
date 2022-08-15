

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_3040 {
	public static StringBuilder sb = new StringBuilder();
	public static int[] real = new int[7];
	public static int[] nanjang = new int[9];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int sum=0;
		for(int i=0;i<9;i++) {
			nanjang[i]=Integer.parseInt(in.readLine());
		}
		dfs(0,0);
		System.out.println(sb);
	}
	private static void dfs(int cnt, int start) {
		//일곱난쟁이
		if(cnt==7) {
			int sum=0;
			for(int i=0;i<7;i++) {
				sum+=real[i];
			}
			if(sum==100) {
				for(int i=0;i<7;i++) {
					sb.append(real[i]).append("\n");
				}
				return;
			}
			return;
		}
		for(int i=start;i<9;i++) {
			real[cnt]=nanjang[i];
			dfs(cnt+1,i+1);
		}
	}
	
}
