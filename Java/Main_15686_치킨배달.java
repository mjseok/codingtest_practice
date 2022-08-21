import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_15686_치킨배달 {
	static int[][]chicken;
	static ArrayList<int[]>house=new ArrayList<>();
	static ArrayList<int[]>chickenPos= new ArrayList<>();
	static int N,M;
	static int answer = Integer.MAX_VALUE; //도시의 치킨거리
	static int[] dx=new int[] {0,0,-1,1};
	static int[] dy=new int[] {-1,1,0,0};
	static int[][] city;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		StringTokenizer st = null;
		str = in.readLine();
		st = new StringTokenizer(str, " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		city = new int[N][N];
		chicken = new int[M][2];
		for (int i = 0; i < N; i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			for (int j = 0; j < N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
				if(city[i][j]==2) chickenPos.add(new int[] {i,j});
				if(city[i][j]==1) house.add(new int[] {i,j});
				
			}
		}
		combi(0,0);//치킨집 m개 골랐다.
		System.out.println(answer);
		
	}
	private static void combi(int start,int cnt) {
		if(cnt == M) {
			for(int i=0;i<chicken.length;i++) {
				bfs();
				//System.out.print(Arrays.toString(chicken[i])+" ");
			}
			//System.out.println();
			//bfs
			return;
		}
		for(int i=start;i<chickenPos.size();i++) {
			chicken[cnt]=chickenPos.get(i);
			combi(i+1,cnt+1);
		}
	}
	private static void bfs() {
		int distance = 0;
		for(int i=0;i<house.size();i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < M; j++) {
				int cal = Math.abs(chicken[j][0]-house.get(i)[0])+Math.abs(chicken[j][1]-house.get(i)[1]);
				min = min >cal? cal : min; 
			}
			distance+=min;
		}
		answer = Math.min(answer,distance);
		return;
		
	}
}
