package Java;
import java.util.*;

public class Java07121 {
    public static int[][] Rotation(int[][] arr){
        int[][] result=new int[arr.length][arr.length];

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                result[i][j]=arr[arr.length-j-1][i];
            }
        }
        return result;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int tc=1;tc<=T;tc++){
            int N=sc.nextInt();
            int[][] arr=new int[N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    arr[i][j]=sc.nextInt();
                }
            }
            int[][] dg90=Rotation(arr);
            int[][] dg180=Rotation(dg90);
            int[][] dg270=Rotation(dg180);
            System.out.printf("#%d\n",tc);

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    System.out.print(dg90[i][j]);
                }
                System.out.print(" ");
                for(int j=0;j<N;j++){
                    System.out.print(dg180[i][j]);
                }
                System.out.print(" ");
                for(int j=0;j<N;j++){
                    System.out.print(dg270[i][j]);
                }
                System.out.println();
            }
        }
    }
    
}
