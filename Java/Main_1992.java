import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1992 {
	static StringBuilder sb = new StringBuilder();
	static int[][] video;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		video = new int[N][N];
		String str="";
		StringTokenizer st = null;
		for(int i=0;i<N;i++) {
			str=in.readLine();
			for (int j = 0; j < N; j++) {
				video[i][j]=str.charAt(j)-'0';
			}
		}
		QT(0,0,N);
		System.out.println(sb);
		
	}
	private static void QT(int r,int c,int size) {
		int tmp =0;
		for(int i=r;i<r+size;i++) {
			for(int j=c;j<c+size;j++) {
				tmp+=video[i][j];
			}
		}
		if(tmp==size*size) {
			sb.append("1");
		}
		else if(tmp==0) {
			sb.append("0");
		}
		else {
			sb.append("(");
			QT(r,c,size/2);
			QT(r,c+size/2,size/2);
			QT(r+size/2,c,size/2);
			QT(r+size/2,c+size/2,size/2);
			sb.append(")");		
		}
	}
}
