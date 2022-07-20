import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.Reader;
import java.util.StringTokenizer;
//암기하기
public class JavaInOutPut {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		InputStream is = System.in;
//		Reader r= new InputStreamReader(is);  	
//		BufferedReader in = new BufferedReader(r);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(in.readLine()); //test cast수
		String str="";
		StringTokenizer st =null;
		int answer=0;
		StringBuilder sb=new StringBuilder();
		
		for(int tc=1;tc<=T;tc++) {
			sb.append("#").append(tc).append(" ");//System.out.println("#"+tc+" "+answer);
			int N=Integer.parseInt(in.readLine());// 배열 크기
			char[][] map=new char[N][N];
			for (int i = 0; i < N; i++) {
				str=in.readLine();
				st=new StringTokenizer(str," ");//공백으로 tokenizer하겠다.
				for(int j=0;j<N;j++) {
					map[i][j]=st.nextToken().charAt(0);
				}
			}
		
			//TODO:logic
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
}