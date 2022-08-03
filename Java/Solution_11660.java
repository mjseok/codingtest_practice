package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_11660_구간합5 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str="";
		StringTokenizer st = null;
		StringBuilder sb=new StringBuilder();
		str=in.readLine();
		int N = Integer.parseInt(str.split(" ")[0]);
		int M = Integer.parseInt(str.split(" ")[1]);
		int[][] map=new int[N][N];
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
		
		for(int i=0;i<M;i++) {
			str=in.readLine();
			st=new StringTokenizer(str," ");
			int a=Integer.parseInt(st.nextToken())-1;
			int b=Integer.parseInt(st.nextToken())-1;
			int c=Integer.parseInt(st.nextToken())-1;
			int d=Integer.parseInt(st.nextToken())-1;
			int dap=0;
			if(a==0 && b!=0) dap=njhap[c][d]-njhap[c][b-1];
			else if(b==0&& a!=0)dap=njhap[c][d]-njhap[a-1][d];
			else if(a==0 && b==0) dap=njhap[c][d];
			else dap=njhap[c][d]-njhap[c][b-1]-njhap[a-1][d]+njhap[a-1][b-1];
			sb.append(dap).append("\n");
			
		}
		System.out.println(sb);
	}
}
