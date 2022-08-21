import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2961_도영이 {
	static ArrayList <int []> ingredients;
	static int[][] combi;
	static boolean[] visited;
	static int N;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		String str ="";
		StringTokenizer st = null;
		ingredients = new ArrayList<>();
		visited = new boolean[N];
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(in.readLine()," ");
			ingredients.add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
		}
		for(int i=1;i<=N;i++) {
			combi = new int[i][2];
			combi(0,0,i);
		}
		System.out.println(min);
	}
	private static void combi(int start,int cnt,int r) {
		if(cnt==r) {
			int sour =1;
			int bitter=0;
			for (int i = 0; i < r; i++) {
				sour*=combi[i][0];
				bitter+=combi[i][1];
			}
			min= min > (Math.abs(sour-bitter))? (Math.abs(sour-bitter)):min ;
			return;
		}
		for(int i=start;i<N;i++) {
			combi[cnt]=ingredients.get(i);
			combi(i+1,cnt+1,r);
		}
	}
}
