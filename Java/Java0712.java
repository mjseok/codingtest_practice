package Java;
import java.util.*;

public class Java0711 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();

        for(int tc=1;tc<=T;tc++){
            int N=sc.nextInt();
            int M=sc.nextInt();
    
            int[][] arr=new int[N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    arr[i][j]=sc.nextInt();
                }
            } 
            int max=0;
            for(int i=0;i<=N-M;i++){
                for(int j=0;j<=N-M;j++){
                    int fly=0;
                    for(int ii=0;ii<M;ii++){
                        for(int jj=0;jj<M;jj++){
                            fly+=arr[i+ii][j+jj];
                        }
                    }
                    if(max<fly){
                        max=fly;
                    }
                }
            }
            System.out.printf("#%d %d\n",tc,max);

        }
        
    }
}
