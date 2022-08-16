import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1861 {
	static int[][] room;
	static int N;
	static int[] dx=new int[] {0,0,-1,1};
	static int[] dy=new int[] {-1,1,0,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = "";

		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(in.readLine());
			room = new int[N][N];
			int max = Integer.MIN_VALUE;
			ArrayList<Integer> maxArr = new ArrayList<>();
			int ans =Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				str = in.readLine();
				StringTokenizer st = new StringTokenizer(str, " ");
				for (int j = 0; j < N; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					int tmp = move(i,j,0);
					System.out.println(i+" "+j+" "+tmp);
					max = max <tmp ? tmp: max;
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					int tmp = move(i,j,0);
					if(max == tmp) {
						ans = ans < room[i][j] ? ans: room[i][j]; 
					}
				}
			}
			sb.append(ans).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}
	private static int move(int x,int y,int cnt) {
		Queue<int []> queue = new LinkedList<>();
		queue.add(new int[] {x,y,1});
		int num=1;
		while(!queue.isEmpty()) {
			int []pos = queue.poll();
			int curX=pos[0];
			int curY=pos[1];
			num = pos[2];
			for(int d=0;d<4;d++) {
				int nx=curX+dx[d];
				int ny=curY+dy[d];
				if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
				if(room[curX][curY]+1==room[nx][ny]) {
					queue.add(new int[] {nx,ny,num+1});
				}
			}
		}
		return num;
	}
}
