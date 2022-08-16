import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1828 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str ="";
		StringTokenizer st = null;
		int N = Integer.parseInt(in.readLine());
		int[][] refrigerator=new int[N][2];
		for(int i=0;i<N;i++) {  
			str=in.readLine();
			st=new StringTokenizer(str," ");
			refrigerator[i][0]=Integer.parseInt(st.nextToken());
			refrigerator[i][1]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(refrigerator,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[1]-o2[1];
			}
			
		});
		int num=1;
		int max = refrigerator[0][1];
		for(int i=0;i<N;i++) {
			 if(refrigerator[i][0]>max) {
				 max = refrigerator[i][0];
				 num+=1;
			 }
		}
		System.out.println(num);
		
	}
}
