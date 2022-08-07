package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2493 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N=Integer.parseInt(in.readLine());
		Stack<Integer> top= new Stack<>();
		int[] findIdx=new int[N];
		
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str," ");
		
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(st.nextToken());
			findIdx[i]=num; //idx에 어떤 값인지 확인하기 위해서
			while(!top.isEmpty()) {
				if(findIdx[top.peek()]<num) { //해당 index값의 숫자가 넣을 숫자보다 작으면
					top.pop(); //의미 없으니까pop
				}
				else {
					sb.append(top.peek()+1).append(" "); //큰 숫자면 바로 그 위치 넣기
					break;
				}
				
			}
			if(top.isEmpty())sb.append(0).append(" "); // 비어있으면 되는 위치 없으니까 0
			top.push(i); //일단 넣기
		}
		System.out.println(sb);
	}
}
