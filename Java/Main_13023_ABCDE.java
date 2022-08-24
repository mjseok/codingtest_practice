import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_13023_ABCDE {
	static int answer=0;
	static boolean[] isVisit;
	static ArrayList<Integer>[] array;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str ="";
		StringTokenizer st = null;
		str=in.readLine();
		st = new StringTokenizer(str," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		array = new ArrayList[N];
		isVisit = new boolean[N];
		for(int i=0;i<N;i++) {
			array[i] = new ArrayList<>();
		}
		for(int i=0;i<M;i++) {
			str=in.readLine();
			st = new StringTokenizer(str," ");
			int friend1 = Integer.parseInt(st.nextToken());
			int friend2 = Integer.parseInt(st.nextToken());
			array[friend1].add(friend2);
			array[friend2].add(friend1);
		}
		
		/*for(int i=0;i<N;i++) {
			System.out.print(i+"---->");
			for (int j = 0; j < array[i].size(); j++) {
				System.out.print(array[i].get(j)+" ");
			}
			System.out.println();
		}*/
		for(int i=0;i<N;i++) {		
			isVisit[i]=true;
			dfs(i,0);
			if(answer == 1 ) break;
			isVisit[i]=false;
		}
		System.out.println(answer);
	}
	private static void dfs(int start,int depth) {
		if(depth==4) {
			answer=1;
			return;
		}
		int len = array[start].size();
		for (int i = 0; i < len; i++) {
			int friend = array[start].get(i);
			if(!isVisit[friend]) {
				isVisit[friend] = true;
				dfs(friend,depth+1);
				isVisit[friend]=false;
			}
		}
		
	}
}
