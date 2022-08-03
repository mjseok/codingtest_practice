package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1873 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(in.readLine());
		String str="";
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		//test case시작
		for(int tc=1;tc<=T;tc++) {
			sb.append("#").append(tc).append(" ");
			str=in.readLine();
			st = new StringTokenizer(str," ");
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			char[][] map = new char[H][W]; 
			for(int i=0;i<H;i++) {
				str=in.readLine();
				for(int j=0;j<W;j++) {
					map[i][j]=str.charAt(j);
				}
			}
			
			int N = Integer.parseInt(in.readLine());
			char[] movement = new char[N];
			str=in.readLine();
			for(int i=0;i<N;i++) {
				movement[i]=str.charAt(i);
			}			
			//입력받기 완료
			int []car = new int[3];//차의 위치,방향(0:위,1:아래,2:왼쪽,3:오른쪽)
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					if(map[i][j]=='^') {
						car[0]=i;
						car[1]=j;
						car[2]=0;
					}
					if(map[i][j]=='v') {
						car[0]=i;
						car[1]=j;
						car[2]=1;
					}
					if(map[i][j]=='<') {
						car[0]=i;
						car[1]=j;
						car[2]=2;
					}
					if(map[i][j]=='>'){
						car[0]=i;
						car[1]=j;
						car[2]=3;
					}
				}
			}
			for(int i=0;i<N;i++) {
				if(movement[i]=='U') {
					car[2]=0;//바라보는 방향을 위쪽으로 바꿈
					if(car[0]>0&&map[car[0]-1][car[1]]=='.') {//이동가능하면
						map[car[0]][car[1]]='.';//있던 땅은 평지
						car[0]-=1;//위로한칸
					}	
				}
				else if (movement[i]=='D') {
					car[2]=1;//바라보는 방향을 아래로
					if(car[0]<H-1&&map[car[0]+1][car[1]]=='.') {//이동가능하면
						map[car[0]][car[1]]='.';//있던 땅 평지
						car[0]+=1;//아래로한칸
					}	
				}
				else if(movement[i]=='L') {
					car[2]=2;//바라보는 방향을 왼쪽으로 바꿈
					if(car[1]>0&&map[car[0]][car[1]-1]=='.') {//이동가능하면
						map[car[0]][car[1]]='.';//있던 땅은 평지
						car[1]-=1;//왼쪽으로한칸
					}	
				}
				else if(movement[i]=='R') {
					car[2]=3;//바라보는 방향을 오른쪽으로 바꿈
					if(car[1]<W-1&&map[car[0]][car[1]+1]=='.') {//이동가능하면
						map[car[0]][car[1]]='.';//있던 땅은 평지
						car[1]+=1;//오른쪽으로한칸
					}	
				}
				else {//'S'입력
					int start=car[0];
					int end=car[1];
					//쏘는 방향이 위
					if(car[2]==0) {
						while(true) {
							start-=1;
							if(start<0) break;
							if(map[start][end]=='#') break;
							if(map[start][end]=='*') {
								//벽 부수고
								map[start][end]='.';
								break;
							}
						}
					}
					//쏘는 방향이 아래
					if(car[2]==1) {
						while(true) {
							start+=1;
							if(start>=H) break;
							if(map[start][end]=='#') break;
							if(map[start][end]=='*') {
								//벽 부수고
								map[start][end]='.';
								break;
							}
						}
					}
					//쏘는 방향이 왼쪽
					if(car[2]==2) {
						while(true) {
							end-=1;
							if(end<0) break;
							if(map[start][end]=='#') break;
							if(map[start][end]=='*') {
								//벽 부수고
								map[start][end]='.';
								break;
							}
						}
					}
					//쏘는 방향이 오른쪽
					if(car[2]==3) {
						while(true) {
							end+=1;
							if(end>=W) break;
							if(map[start][end]=='#') break;
							if(map[start][end]=='*') {
								//벽 부수고
								map[start][end]='.';
								break;
							}
						}
					}
				}
			}
			//전차 방향만 바꿔주고 출력
			if(car[2]==0) {
				map[car[0]][car[1]]='^';
			}
			if(car[2]==1) {
				map[car[0]][car[1]]='v';
			}
			if(car[2]==2) {
				map[car[0]][car[1]]='<';
			}
			if(car[2]==3) {
				map[car[0]][car[1]]='>';
			}
			for(int i=0;i<H;i++) {
				for(int j =0;j<W;j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
