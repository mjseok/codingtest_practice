import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_10026_적록색약 {
	static int[] dx = new int[] { 0, 0, -1, 1 };
	static int[] dy = new int[] { -1, 1, 0, 0 };
	static boolean[][] normalVisit;
	static boolean[][] RGVisit;
	static String[][] map, RGmap;
	static int N,normal,RG;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new String[N][N];
		RGmap = new String[N][N];
		normalVisit = new boolean[N][N];
		RGVisit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) + "";
				if(map[i][j].equals("G")) RGmap[i][j] = "R";
				else RGmap[i][j] = map[i][j];
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!normalVisit[i][j]) normal(i,j);
				if(!RGVisit[i][j]) RGweakness(i,j);
			}
		}
		sb.append(normal).append(" ").append(RG);
		System.out.println(sb);

	}

	private static void normal(int startX,int startY) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {startX,startY});
		String area=map[startX][startY];
		normal++;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int x = cur[0];
			int y = cur[1];
			if(!map[x][y].equals(area)) break;
			for (int d = 0; d < 4; d++) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				if(!check(nx,ny)) continue;
				if(map[nx][ny].equals(area) && !normalVisit[nx][ny]) {
					normalVisit[nx][ny]=true;
					queue.add(new int[] {nx,ny});
				}
			}
			
			
		}
	}

	private static void RGweakness(int startX,int startY) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {startX,startY});
		String area=RGmap[startX][startY];
		RG++;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int x = cur[0];
			int y = cur[1];
			if(!RGmap[x][y].equals(area)) break;
			for (int d = 0; d < 4; d++) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				if(!check(nx,ny)) continue;
				if(RGmap[nx][ny].equals(area) && !RGVisit[nx][ny]) {
					RGVisit[nx][ny]=true;
					queue.add(new int[] {nx,ny});
				}
			}
			
			
		}
	}
	private static boolean check(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}
