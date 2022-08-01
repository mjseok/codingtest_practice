import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1244 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(in.readLine());
		int[] switches=new int[n+1];
		String str="";
		str= in.readLine();
		StringTokenizer st = new StringTokenizer(str," ");
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<n+1;i++) {
			switches[i]=Integer.parseInt(st.nextToken());
		}
		int studentN=Integer.parseInt(in.readLine());
		for(int i=1;i<=studentN;i++) {
			str=in.readLine();
			int gender=Integer.parseInt(str.split(" ")[0]);
			int num=Integer.parseInt(str.split(" ")[1]);
			if(gender==1) {
				for(int j=num;j<=n;j+=num) {
					if(switches[j]==0) switches[j]=1;
					else switches[j]=0;
				}
			}
			else{
				for(int j=0;j<=n/2;j++) {
					if(num>j && num<=n-j) {
						if(switches[num-j]==switches[num+j]) {
							if(switches[num-j]==0) {
								switches[num-j]=1;
								switches[num+j]=1;
							}
							else {
								switches[num-j]=0;
								switches[num+j]=0;
							}
						}else {
							break;
						}
					}else break;
				}
			}
			
		}
		for(int i=1;i<=n;i++) {			
			sb.append(switches[i]).append(" ");
			if(i%20==0) sb.append("\n");
		}
		System.out.println(sb);
	}
}
// 0 1 0 1 0 0 0 1
// 0 1 1 1 0 1 0 1
  
