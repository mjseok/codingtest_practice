package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1233 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str="";
		StringTokenizer st = null;
		for(int tc=1;tc<=1;tc++) {
			int res =1;
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(in.readLine());
			
			for(int i=0;i<N;i++) {
				str= in.readLine();
				st = new StringTokenizer(str," ");
				String[] arr = str.split(" ");
				int v = Integer.parseInt(st.nextToken());
				//int v = Integer.parseInt(arr[0]);
				String isOperator = st.nextToken();
				System.out.println(isOperator);
				if(isOperator.equals("+")||isOperator.equals("-")||isOperator.equals("*")||isOperator.equals("/")) {//연산자면
					if(st.countTokens()==2) {
						continue;
					}
					else {
						res=0;
					}
					/*if(st.countTokens()!=2) {
						res=0;
						break;
					}*/
				/*	if(arr.length!=4) {
						res=0;
						break;
					}*/
				}
				else {//연산자가 아니면
					//입력 들어오면 안됨
					if(st.countTokens()==0) {
						continue;
					}
					else {
						res=0;
					}
					/*if(st.countTokens()!=0) {
						res=0; 
						break;
					}*/
				/*	if(arr.length!=2) {
						res=0;
						break;
					}*/
				}
				
				
			}
			
			sb.append(res).append("\n");
		}
		System.out.println(sb);
	}
}
