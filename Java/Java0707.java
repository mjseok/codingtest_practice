package Java;

import java.util.*;

public class Java0707 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int tc=1;tc<=T;tc++){
            int N=sc.nextInt();
            int M=sc.nextInt();

            int[] A=new int[N];
            int[] B=new int[M];
            
            for(int i=0;i<A.length;i++) A[i]=sc.nextInt();
            for(int j=0;j<B.length;j++) B[j]=sc.nextInt();
            
            int Max=0;
            
            if(M>N){
                for(int i=0;i<M-N+1;i++){
                    int result=0;
                    for(int j=0;j<N;j++){
                        result+=A[j]*B[i+j];
                    }
                    Max=Math.max(Max,result);
                }
            }
            if(N>M){
                for(int i=0;i<N-M+1;i++){
                    int result=0;
                    for(int j=0;j<M;j++){
                        result+=A[j+i]*B[j];
                    }
                    Max=Math.max(Max,result);
                }
            }
            
            if(N==M){
                int result=0;
                for(int a=0;a<N;a++){
                    result+=A[a]*B[a];
                }
                Max=Math.max(Max,result);
            }
            System.out.printf("#%d %d\n",tc,Max);

        }
    }
    
}
