import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_4485_녹색옷젤다 {
	static int[] dx= {0,1,-1,0};
	static int[] dy= {1,0,0,-1};
	static int[][] move,map;
	static PriorityQueue<int[]>pq;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int no = 1;
		while(true) {
			N = Integer.parseInt(in.readLine());
			map = new int[N][N];
			move = new int[N][N];
			if(N==0) break;
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(in.readLine()," ");
				for(int j =0;j<N;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
					move[i][j]=Integer.MAX_VALUE;
				}
			}
			sb.append("Problem ").append(no).append(": ").append(findMin()).append("\n");
			no++;
		}
		System.out.println(sb);
	}
	private static int findMin() {
		pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];//0: x 1:y 2: weight
			}
			
		});
		move[0][0] = map[0][0];
		pq.offer(new int[] {0,0,map[0][0]});
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int x = cur[0];
			int y = cur[1];
			int w = cur[2];
			if(x==N-1 && y==N-1) {
				return move[x][y];
			}
			if(move[x][y]<w) continue;
			for (int i = 0; i < 4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(!check(nx,ny)) continue;
				if(map[nx][ny]+w < move[nx][ny]) {
					move[nx][ny] = map[nx][ny]+w;
					pq.offer(new int[] {nx,ny,move[nx][ny]});
				}
			}
		}
		return 0;
	}
	private static boolean check(int x, int y) {
		return x>=0 && x<N && y>=0 && y<N;
	}
}
