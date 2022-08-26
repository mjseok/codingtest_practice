import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_7465_창용마을 {
	static class Edge {
		int from, to;

		public Edge(int from, int to) {
			this.from = from;
			this.to = to;
		}
	}

	static int[] parents;
	static int N, M;
	static Edge[] edgeList;

	static void make() {
		parents = new int[N];
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}

	static int find(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			String str = "";
			StringTokenizer st = null;
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			N = Integer.parseInt(st.nextToken());// 정점
			M = Integer.parseInt(st.nextToken());// 간선 수
			edgeList = new Edge[M];
			for (int i = 0; i < M; i++) {
				str = in.readLine();
				st = new StringTokenizer(str, " ");
				int p1 = Integer.parseInt(st.nextToken())-1;
				int p2 = Integer.parseInt(st.nextToken())-1;
				edgeList[i]= new Edge(p1,p2);
			}
			make();
			int cnt =N;
			for(Edge edge:edgeList) {
				if(union(edge.from,edge.to)) {
					cnt--;
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
