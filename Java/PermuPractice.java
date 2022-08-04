package practice;

import java.util.Arrays;
import java.util.Scanner;

public class PermuPractice {
	static int N,R,totalCnt;
	static int[] numbers,input;
	static boolean[] isSelected;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		R = sc.nextInt();
		
		numbers = new int[R];
		input = new int[N];
		isSelected = new boolean[N];
		
		for(int i=0;i<N;i++) {
			input[i]=sc.nextInt();
		}
		perm(0);
		System.out.println("총 경우의 수 : "+totalCnt);
	}
	private static void perm(int cnt) {
		if(cnt==R) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i=0;i<N;i++) {
			if(isSelected[i]) continue;
			numbers[cnt]=input[i];
			isSelected[i]= true;
			perm(cnt+1);
			isSelected[i]=false;
			
		}
	}
}
