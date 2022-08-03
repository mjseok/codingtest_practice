package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_11659_구간합4 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str="";
		StringTokenizer st = null;
		str=in.readLine();
		st=new StringTokenizer(str, " ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr=new int[N];
		int[] njhap=new int[N+1];
		str=in.readLine();
		st=new StringTokenizer(str, " ");
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		njhap[0]=0;
		for(int i=1;i<=N;i++) {
			njhap[i]=arr[i-1]+njhap[i-1];
		}
		for(int t=0;t<M;t++) {
			str=in.readLine();
			int i=Integer.parseInt(str.split(" ")[0]);
			int j=Integer.parseInt(str.split(" ")[1]);
			int dap=njhap[j]-njhap[i-1];
			sb.append(dap).append("\n");
		}
		System.out.println(sb);
		
	}
}
