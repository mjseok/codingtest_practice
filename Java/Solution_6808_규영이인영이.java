import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_6808_규영이인영이 {
	static boolean[] isVisited;
	static int[] inyoung, gyu;
	static ArrayList<String> cards;
	static int[] gameResult;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			gyu = new int[9];
			isVisited = new boolean[9];
			inyoung = new int[9];
			cards = new ArrayList<>();
			for (int i = 1; i <= 18; i++) {
				cards.add(i + "");
			}
			gameResult = new int[2];// 이기고 지는것만 저장
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < 9; i++) {
				String num = st.nextToken();
				gyu[i] = Integer.parseInt(num);
				cards.remove(num);
			} // input
			perm(0);
			sb.append(gameResult[0]).append(" ").append(gameResult[1]).append("\n");
		}
		System.out.println(sb);
	}

	private static void perm(int cnt) {
		if (cnt == 9) {
			// count++;
			int gyuScore=0;
			int inyoungScore =0;
			//System.out.println(Arrays.toString(inyoung));
			for(int i=0;i<9;i++) {
				if(gyu[i]>inyoung[i]) {
					gyuScore+=gyu[i]+inyoung[i];
				}
				if(gyu[i]<inyoung[i]) {
					inyoungScore+=gyu[i]+inyoung[i];
				}
			}
			if(gyuScore>inyoungScore) {
				gameResult[0]++;
			}
			else if(gyuScore<inyoungScore) {
				gameResult[1]++;
			}
			return;
		}
		for (int i = 0; i < 9; i++) {
			if (isVisited[i])
				continue;
			isVisited[i] = true;
			inyoung[cnt] = Integer.parseInt(cards.get(i));
			perm(cnt + 1);
			inyoung[cnt] = 0;
			isVisited[i] = false;
		}

	}
}
