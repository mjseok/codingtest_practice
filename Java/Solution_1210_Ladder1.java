package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1210_Ladder1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int tc = 1;tc<=10;tc++) {
			int num=Integer.parseInt(in.readLine());
			sb.append("#").append(num).append(" ");
			String str="";
			StringTokenizer st = null;
			String[][] ladder=new String[100][100];
			
			for(int y=0;y<100;y++) {
				str=in.readLine();
				st=new StringTokenizer(str," ");
				for(int x=0;x<100;x++) {
					ladder[x][y]=st.nextToken();
				}
			}
			int start=0;
			for(int i=0;i<100;i++) {
				if (ladder[i][99].equals("2")) {
					start=i;
				}
			}
			//start는 시작 x
			for(int y=99;y>=0;y--) {//[x][y],층
				//왼쪽에 길이 있다.
				if(start>0 && ladder[start-1][y].equals("1")) {
					//계속 길이 있을때까지 왼쪽으로감
					while(start>0 && ladder[start][y].equals("1")) {
						start-=1;
					}
					//나왔을때는 없는 길이니까
					if(start!=0)
						start+=1;
				}
				//오른쪽에 길이 있다. 
				else if(start<99 && ladder[start+1][y].equals("1")) {
					//계속 길이 있을때까지 왼쪽으로감
					while(start<99 &&ladder[start][y].equals("1")) {
						start+=1;
					}
					//나왔을때는 없는 길이니까
					if(start!=99)
						start-=1;
				}
				//좌우에 길이 없다
				else {
					continue;
				}
				
			}
			sb.append(start).append("\n");	
		}
		System.out.println(sb);
	}
}
