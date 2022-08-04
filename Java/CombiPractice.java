package practice;

import java.util.Arrays;
import java.util.Scanner;

public class CombiPractice {
	static int N,R,totalCnt;
	static int[] numbers,input;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		totalCnt = 0;
		input = new int[N];
		numbers = new int[R]; //R개 뽑힌거
		for (int i = 0; i < N ; i++) {
			input[i]=sc.nextInt();
		}
		comb(0,0);
		System.out.println("총 경우의 수 : "+totalCnt);
	}
	private static void comb(int cnt,int start) {
		if(cnt==R) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i=start;i<N;i++) {
			numbers[cnt]=input[i];
			comb(cnt+1,i+1);
		}
	}
}
