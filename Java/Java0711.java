package Java;
import java.util.*;

public class Java0711 {
    public static void main(String[] args){
    
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int tc=1;tc<=T;tc++){
            int N=sc.nextInt();
            int K=sc.nextInt();
            
            int[][] arr=new int[N][N];
            
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    arr[i][j]=sc.nextInt();
                }
            } 
            int answer=0;
            for(int i=0;i<N;i++){
                int cnt=0;
                for(int j=0;j<N;j++){
                    if(arr[i][j]==1){
                        cnt+=1;
                    }
                    if(arr[i][j]==0 || j==N-1){
                        if(cnt==K){
                            answer+=1;
                        }
                        cnt=0;
                    }
                }
                for(int j=0;j<N;j++){
                    if(arr[j][i]==1){
                        cnt+=1;
                    }
                    if(arr[j][i]==0 || j==N-1){
                        if(cnt==K){
                            answer+=1;
                        }
                        cnt=0;
                    }
                }
            }
            System.out.printf("#%d %d\n",tc,answer);
        }
    }
}
