package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2023 {
	static int N;
	static StringBuilder sb;
	static int []first =new int[]{2,3,5,7};
	static int []rest =new int[]{1,3,5,7,9};
	static int flen = first.length;
	static int rlen = rest.length;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		sb = new StringBuilder();
		makeNum("",0);
		System.out.println(sb);
	}
	private static void makeNum(String num,int cnt) {

		//기저조건
		if(cnt == N) {
			sb.append(num).append("\n");
			return;
		}
		
		if(cnt==0) {
			for(int i=0;i<flen;i++) {
				makeNum(num+first[i],cnt+1);
			}
		}
		else {
			for(int i=0;i<rlen;i++) {
				if(isSosu(Integer.parseInt(num+rest[i]))) {
					makeNum(num+rest[i],cnt+1);					
				}
			}
			
		}
		
		
	}
	//소수 확인
	private static boolean isSosu(int num) {
		for(int i=2;i<=Math.sqrt(num);i++) {
			if(num%i==0) return false;
		}
		return true;
	}
}
