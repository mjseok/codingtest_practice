import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1546 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		double[] subject = new double[N];
		double max = Integer.MIN_VALUE;
		String str=in.readLine();
		StringTokenizer st = new StringTokenizer(str," ");
		for(int i=0;i<N;i++) {
			subject[i]= Integer.parseInt(st.nextToken());
			max = max < subject[i] ? subject[i]:max; 
		}
		double avg=0;
		for(int i=0;i<N;i++) {
			avg+=(subject[i]/max)*100;
		}
		avg/=N;
		System.out.println(avg);
		
	}
}
//50 100 75