import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// swea 1959 두 개의 숫자열(BufferedReader버전)
public class Solution {
	public static void main(String[] args) throws IOException {
		
		BufferedReader in=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\SSAFY\\workspace\\java\\ws_3\\src\\com\\ssafy\\ws\\step3\\input.txt"))));
		int T=Integer.parseInt(in.readLine());
		String str="";
		StringTokenizer st=null;
		StringBuilder sb=new StringBuilder();
		
		for(int tc=1;tc<=T;tc++) {
			sb.append("#").append(tc).append(" ");
			str=in.readLine();
			st=new StringTokenizer(str," ");
			int A=Integer.parseInt(st.nextToken());
			int B=Integer.parseInt(st.nextToken());
			
			int[] strA=new int[A];
			int[] strB=new int[B];
			
			
			str=in.readLine();
			st=new StringTokenizer(str," ");
			for(int i=0;i<A;i++) {
				strA[i]=Integer.parseInt(st.nextToken());
			}
			str=in.readLine();
			st=new StringTokenizer(str," ");
			for(int i=0;i<B;i++) {
				strB[i]=Integer.parseInt(st.nextToken());
			}
			
			int max=Integer.MIN_VALUE;
			if(A>B) {
				for(int i=0;i<A-B+1;i++) {					
					int tmp=0;
					for(int j=0;j<B;j++) {
						tmp+=strA[i+j]*strB[j];
						
					}
					if(tmp>max) max=tmp;
				}
			}
			if(A<B) {
				for(int i=0;i<B-A+1;i++) {					
					int tmp=0;
					for(int j=0;j<A;j++) {
						tmp+=strA[j]*strB[i+j];
					}
					
					if(tmp>max) max=tmp;
				}
			}
			if(A==B) {
				int tmp=0;
				for(int i=0;i<A;i++) {					
					tmp+=strA[i]*strB[i];
				}
				if(tmp>max) max=tmp;
				
			}
			
			sb.append(max).append("\n");
			
		}
		System.out.println(sb);
	}
	
}
