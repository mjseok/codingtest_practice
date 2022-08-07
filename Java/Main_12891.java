package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_12891 {
	public static StringBuilder sb = new StringBuilder();
	static int[] needed;// 얼마나 필요한지
	static int totalCnt = 0;
	static String tmpStr = "";

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int p = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		char[] dna = new char[p];
		needed = new int[4];
		int[] cnt = new int[4];//지금 부분문자열이 갖고 있는 갯수
		str = in.readLine();
		for (int i = 0; i < p; i++) {
			dna[i] = (str.charAt(i));
			
		}
		str = in.readLine();
		st = new StringTokenizer(str, " ");
		for (int i = 0; i < 4; i++) {
			needed[i] = Integer.parseInt(st.nextToken());
		}
		
		//처음은 저장해두고
		for(int i=0;i<s;i++) {
			if(dna[i]=='A')cnt[0]++;
			else if(dna[i]=='C')cnt[1]++;
			else if(dna[i]=='G')cnt[2]++;
			else if(dna[i]=='T')cnt[3]++;
			else break;
		}
		if(isDNA(cnt)) totalCnt++;
		//부분문자열이 끝에 도달할 때까지 한칸씩 이동
		for(int i=1;i<=dna.length-s;i++) {
			if(dna[i-1]=='A') cnt[0]--;
			else if(dna[i-1]=='C') cnt[1]--;
			else if(dna[i-1]=='G') cnt[2]--;
			else if(dna[i-1]=='T') cnt[3]--;
			else break;
			
			if(dna[i+s-1]=='A') cnt[0]++;
			else if(dna[i+s-1]=='C') cnt[1]++;
			else if(dna[i+s-1]=='G') cnt[2]++;
			else if(dna[i+s-1]=='T') cnt[3]++;
			else break;
			
			if(isDNA(cnt)) totalCnt++;
		}
		sb.append(totalCnt);
		System.out.println(sb);
	}

	private static boolean isDNA(int[] cnt) {
		for (int i = 0; i < 4; i++) {
			// 필요한게 더 많으면 불가능
			if (cnt[i] < needed[i])
				return false;
		}
		return true;
	}
}
