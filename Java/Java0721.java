package Java;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java0721 {
    public static void main(String[] args) throws IOException{
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        
        int[][]dp= new int[30][30];
        for(int i=0;i<30;i++){
            dp[i][i]=1;
            dp[i][0]=1;
        }

        for(int i=2;i<30;i++){
            for(int j=1;j<30;j++){
                dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
            }
        }        
        int T=Integer.parseInt(in.readLine());
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();
        for(int testCase=0;testCase<T;testCase++){
            st= new StringTokenizer(in.readLine()," ");
            
            int N=Integer.parseInt(st.nextToken());
            int M=Integer.parseInt(st.nextToken());
            
            sb.append(dp[M][N]).append('\n');
        }
        System.out.println(sb);
    }
    
}
