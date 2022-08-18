import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_5644 {
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
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int[][] AP = new int[A][5];
			int[] moveA = new int[M];
			int[] moveB = new int[M];
			int[] posA = new int[] { 0, 0 };
			int[] posB = new int[] { 9, 9 };
			ArrayList<Integer>[] map = new ArrayList[100];
			ArrayList<Integer> perform = new ArrayList<>();
			//int[] perform = new int[A];
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					map[i * 10 + j] = new ArrayList<Integer>();
				}
			}
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			for (int i = 0; i < M; i++) {
				moveA[i] = Integer.parseInt(st.nextToken());
			}
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			for (int i = 0; i < M; i++) {
				moveB[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < A; i++) {
				str = in.readLine();
				st = new StringTokenizer(str, " ");
				int x = Integer.parseInt(st.nextToken()) - 1;
				int y = Integer.parseInt(st.nextToken()) - 1;
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				AP[i][0] = y;
				AP[i][1] = x;
				AP[i][2] = c;
				AP[i][3] = p;
				//perform[i] = p;
				perform.add(p);
			}

			Arrays.sort(AP, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o2[3] - o1[3];
				}
			});
			
			Collections.sort(perform,Collections.reverseOrder());
			
			
			for (int i = 0; i < AP.length; i++) {
				AP[i][4] = i;
			}
			for (int a = 0; a < AP.length; a++) {
				int x = AP[a][0];
				int y = AP[a][1];
				int coverage = AP[a][2];
				int p = AP[a][3];
				int name = AP[a][4];
				for (int i = x - coverage; i <= x + coverage; i++) {
					for (int j = y - coverage; j <= y + coverage; j++) {
						if (i < 0 || i >= 10 || j < 0 || j >= 10)
							continue;
						if (Math.abs(x - i) + Math.abs(y - j) <= coverage) {
							map[i * 10 + j].add(name);
						}

					}
				}
			}
			int sum = 0;
			for (int i = 0; i <= M; i++) {
				//System.out.println("T =" + i);
				int a = posA[0] * 10 + posA[1];
				int b = posB[0] * 10 + posB[1];
				if (map[a].size() == 1 && map[b].size() == 1) {
					if (map[a].get(0) == map[b].get(0)) {
						sum += perform.get(map[a].get(0));// 반씩 가진다.
					}
					//겹치는게 없다
					else {
						sum+=perform.get(map[a].get(0))+perform.get(map[b].get(0));
					}
				} else if (map[a].size() >= 2 && map[b].size() == 1) {
					// 겹치는 부분이 있으면
					int n = -1;
					for(int j=0;j<map[a].size();j++) {
						if(map[a].get(j)==map[b].get(0)) {
							n=j;
						}
					}
					if(n==0) sum+=perform.get(map[a].get(1))+perform.get(map[b].get(0));
					else sum+= perform.get(map[a].get(0)) + perform.get(map[b].get(0));
				} else if (map[b].size() >= 2 && map[a].size() == 1) {
					// 겹치는 부분이 있으면
					int n = -1;
					for(int j=0;j<map[b].size();j++) {
						if(map[a].get(0)==map[b].get(j)) {
							n=j;
						}
					}
					if(n==0) sum+=perform.get(map[b].get(1))+perform.get(map[a].get(0));
					else sum+= perform.get(map[a].get(0)) + perform.get(map[b].get(0));
				} else if (map[a].size() >= 2 && map[b].size() >= 2) {
					// 겹치는 부분이 둘 다 동일
					if ((map[a].get(0) == map[b].get(0)) && (map[a].get(1) == map[b].get(1))) {
						sum += perform.get(map[a].get(0)) + perform.get(map[a].get(1));
					}
					// 하나만 겹침
					else if (map[a].get(0) == map[b].get(0)) {
						//idx작은게 perform값 크니까
						
						int maxIdx = map[a].get(1) < map[b].get(1) ? map[a].get(1) : map[b].get(1);
						sum += perform.get(maxIdx) + perform.get(map[a].get(0));
					} else {
						// 안겹침 + (map[a].get(1)==map[b].get(1) || map[a].get(0)==map[b].get(1) ||
						sum += perform.get(map[b].get(0)) + perform.get(map[a].get(0));
					}

				} else {
					if (map[a].size() != 0) {
						sum += perform.get(map[a].get(0));
					}
					if (map[b].size() != 0) {
						sum += perform.get(map[b].get(0));
					}

				}
				if (i != M) {
					if (moveA[i] == 1)
						posA[0] -= 1;
					if (moveA[i] == 2)
						posA[1] += 1;
					if (moveA[i] == 3)
						posA[0] += 1;
					if (moveA[i] == 4)
						posA[1] -= 1;
					if (moveB[i] == 1)
						posB[0] -= 1;
					if (moveB[i] == 2)
						posB[1] += 1;
					if (moveB[i] == 3)
						posB[0] += 1;
					if (moveB[i] == 4)
						posB[1] -= 1;
				}
			}
			 sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}
}
