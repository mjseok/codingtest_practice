package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_1218 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
		String str="";
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=10;tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(in.readLine());
			str=in.readLine();
			Stack<Character> open = new Stack<Character>();
			
			for(int i=0;i<N;i++) {
				
				char check=str.charAt(i);
				if(check=='(' ||check=='[' ||check=='{'||check=='<') {
					open.push(check);
					
				}			
				else {//닫힘
					char pairOpen = open.pop();
					if(check==')' && pairOpen!='(') break;
					else if(check==']'&& pairOpen!='[') break;
					else if(check=='>'&& pairOpen!='<') break;
					else if(check=='}' && pairOpen!='{')break;
					else continue;
				}
			}
			
			if(open.isEmpty()) sb.append(1).append("\n");
			else sb.append(0).append("\n");
			
			
		}
		System.out.println(sb);
		
	}

}
