import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3055_탈출 {
	static int[] dx = new int[] { 0, 0, -1, 1 };
	static int[] dy = new int[] { -1, 1, 0, 0 };
	static Queue<int[]> water = new LinkedList<>();
	static Queue<int[]> dochi = new LinkedList<>();
	static int R, C;
	static char[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		StringTokenizer st = null;
		str = in.readLine();
		st = new StringTokenizer(str, " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			str = in.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == '*')
					water.add(new int[] { i, j });
				if (map[i][j] == 'S')
					dochi.add(new int[] { i, j, 0 });
			}
		}
		bfs();

	}

	private static void bfs() {
		int time = 0;
		while(!dochi.isEmpty()) {
			//물이 먼저
			for (int i = 0,len =water.size(); i < len; i++) {
				int[] curWater = water.poll();
				int wx = curWater[0];
				int wy = curWater[1];
				for (int d = 0; d < 4; d++) {
					int wnx = wx+dx[d];
					int wny = wy+dy[d];
					if(!check(wnx,wny)) continue;
					//물이 퍼질 수 있음
					if(map[wnx][wny]=='.') {
						map[wnx][wny]='*';
						water.add(new int[] {wnx,wny});
					}
				}
			}
			for (int i = 0,len = dochi.size(); i < len; i++) {
				int[] curDochi = dochi.poll();
				int x = curDochi[0];
				int y = curDochi[1];
				int t = curDochi[2];
				for (int d = 0; d < 4; d++) {
					int nx = x+dx[d];
					int ny = y+dy[d];
					if(!check(nx,ny)) continue;
					//지나갈 수 있음
					if(map[nx][ny]=='.') {
						map[nx][ny]='S';
						dochi.add(new int[] {nx,ny,t+1});
						time = t+1;
					}
					//도착
					if(map[nx][ny]=='D') {
						time = t+1;
						System.out.println(time);
						return;
					}
				}
			}
		}
		System.out.println("KAKTUS");
		return;
		
	}

	private static boolean check(int x, int y) {
		return x >= 0 && x < R && y >= 0 && y < C;
	}
}
