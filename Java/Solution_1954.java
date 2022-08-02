import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1954 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(in.readLine());
		StringBuilder sb= new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			sb.append("#").append(tc).append("\n");
			int N = Integer.parseInt(in.readLine());
			int num=1;
			int[][] result = new int[N][N];
			for(int i=0;i<N;i++) {
				result[0][i]=num;
				num++;
			}
			int x=0;
			int y=N-1;
			for(int i=N-1;i>0;i--) {//i는 채우는 칸 수
				//첫번째로 시도하는거면
				if((N-i)%2==1) {
					//아래
					for(int j=0;j<i;j++) {
						x++;
						result[x][y]=num;
						num++;
					}
					//왼쪽
					for(int j=0;j<i;j++) {
						y--;
						result[x][y]=num;
						num++;
					}
				}
				else {
					//위
					for(int j=0;j<i;j++) {
						x--;
 						result[x][y]=num;
						num++;
					}
					//오른쪽
					for(int j=0;j<i;j++) {
						y++;
						result[x][y]=num;
						num++;
					}
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					sb.append(result[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);	
		
	}
}
