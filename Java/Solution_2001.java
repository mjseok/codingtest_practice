package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_2001 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		String str="";
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			sb.append("#").append(tc).append(" ");
			str=in.readLine();
			st=new StringTokenizer(str," ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			for(int i=0;i<N;i++) {
				str=in.readLine();
				st=new StringTokenizer(str," ");				
				for(int j=0;j<N;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			int[][] njhap=new int[N+1][N+1];
			int[][] garo=new int[N+1][N+1];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(j==0)garo[i][j]=map[i][j];
					else garo[i][j]=garo[i][j-1]+map[i][j];
				}
			}
			
			for(int j=0;j<N;j++) {
				for(int i=0;i<N;i++) {
					if(i==0)njhap[i][j]=garo[i][j];
					else njhap[i][j]=njhap[i-1][j]+garo[i][j];
				}
			}
			int max=0;
			int tmp =0;
			for(int i=1;i<N;i++) {
				for(int j=1;j<N;j++) {
					if(i<M  && j<M) tmp=njhap[i][j];
					else if(j<M) tmp=njhap[i][j]-njhap[i-M][j];
					else if(i<M) tmp=njhap[i][j]-njhap[i][j-M];
					else tmp=njhap[i][j]-njhap[i-M][j]-njhap[i][j-M]+njhap[i-M][j-M];
					max = tmp>max? tmp:max;
				}
			}
			sb.append(max).append("\n");
			
		}
		System.out.println(sb);
	}
}
