import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16935 {
	static int N,M;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		String str=in.readLine();
		st = new StringTokenizer(str," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int i=0;i<N;i++) {
			str=in.readLine();
			st = new StringTokenizer(str," ");			
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		str=in.readLine();
		st = new StringTokenizer(str," ");			
		for(int i=0;i<R;i++) {
			int cal=Integer.parseInt(st.nextToken());
			switch(cal) {
			case 1:
				one();
				break;
			case 2:
				two();
				break;
			case 3:
				three();
				break;
			case 4:
				four();
				break;
			case 5:
				five();
				break;
			case 6:
				six();
				break;
			}
		}
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
			
	}
	private static void one() {
		int h = arr.length;
		int w = arr[0].length;
		for(int i=0;i<h/2;i++) {
			for(int j=0;j<w;j++) {
				int tmp=arr[i][j];
				arr[i][j]=arr[h-1-i][j];
				arr[h-1-i][j]=tmp;
			}
		}
	}
	private static void two() {
		int h = arr.length;
		int w = arr[0].length;
		for(int i=0;i<h;i++) {
			for(int j=0;j<w/2;j++) {
				int tmp=arr[i][j];
				arr[i][j]=arr[i][w-1-j];
				arr[i][w-1-j]=tmp;
			}
		}
	}
	private static void three() {
		int h = arr.length;
		int w = arr[0].length;
		int[][] res=new int[w][h];
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				res[j][h-1-i]=arr[i][j];
			}
		}
		arr=res;
	}
	private static void four() {
		int h = arr.length;
		int w = arr[0].length;
		int[][] res=new int[w][h];
		for(int i=0;i<w;i++) {
			for(int j=0;j<h;j++) {
				res[i][j]=arr[j][w-1-i];
			}
		}
		arr=res;
	}
	private static void five() {
		//여기부터
		int h = arr.length;
		int w = arr[0].length;
		int[][] res=new int[h][w];
		for(int i=0;i<h/2;i++) {
			for(int j=0;j<w/2;j++) {
				res[i][j+w/2] = arr[i][j];
			}
		}
		for(int i=0;i<h/2;i++) {
			for(int j=w/2;j<w;j++) {
				res[i+h/2][j] = arr[i][j];
			}
		}
		for(int i=h/2;i<h;i++) {
			for(int j=0;j<w/2;j++) {
				res[i-h/2][j] = arr[i][j];
			}
		}
		for(int i=h/2;i<h;i++) {
			for(int j=w/2;j<w;j++) {
				res[i][j-w/2] = arr[i][j];
			}
		}
		arr=res;
		  
	}
	private static void six() {
		int h = arr.length;
		int w = arr[0].length;
		int[][] res=new int[h][w];
		for(int i=0;i<h/2;i++) {
			for(int j=0;j<w/2;j++) {
				res[i+h/2][j] = arr[i][j];
			}
		}
		for(int i=0;i<h/2;i++) {
			for(int j=w/2;j<w;j++) {
				res[i][j-w/2] = arr[i][j];
			}
		}
		for(int i=h/2;i<h;i++) {
			for(int j=0;j<w/2;j++) {
				res[i][j+w/2] = arr[i][j];
				
			}
		}
		for(int i=h/2;i<h;i++) {
			for(int j=w/2;j<w;j++) {
				res[i-h/2][j] = arr[i][j];
			}
		}
		arr=res;
	}
}
