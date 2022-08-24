import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_1238_Contact {
	static boolean[] isVisit;
	static ArrayList<ArrayList<Integer>> graph;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = "";
		StringTokenizer st = null;
		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			int len = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			graph= new ArrayList<>();
			Set<int[]> set = new HashSet<>();
			isVisit = new boolean[101];
			for (int i = 0; i < 101; i++) {
				graph.add(new ArrayList<>());
			}
			str = in.readLine();
			st = new StringTokenizer(str, " ");
		
			for (int i = 0; i < len / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				if(set.contains(new int[] {from,to})) continue;
				set.add(new int[] {from,to});
			}
			for(int[] info:set) {
				graph.get(info[0]).add(info[1]);
			}
			bfs(start);
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
		
	}
	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		isVisit[start]=true;
		while(!queue.isEmpty()) {
			int size = queue.size();
			int max =0;
			while(--size >=0) {
				int cur = queue.poll();
				for (int i = 0; i <graph.get(cur).size(); i++) {
					int num = graph.get(cur).get(i);
					if(!isVisit[num]) {
						queue.offer(num);
						isVisit[num]=true;
						max = max < num ? num:max;
					}
				}
			}
			if(max>0) answer = max;
		}
		
	}
}
