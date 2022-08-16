package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2839 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int pack=0;
		
		while(N>0) {
			if(N%5!=0) {
				N-=3;
				pack+=1;
				if (N<0) {
					pack=-1;
					break;
				}
			}
			else if(N%5==0){
				pack += N/5;
				break;
			}
			else if(N%5!=0 && N%3!=0) {
				pack=-1;
			}			
		}
		System.out.println(pack);
	}
}
