package Java;
import java.util.*;

public class Java0713 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int tc=1;tc<=T;tc++){
            int[][] arr=new int[9][9];
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    arr[i][j]=sc.nextInt();
                }
            }
            int answer=1;
            for(int i=0;i<9;i++){
                int[] checkR=new int[9];
                for(int k=0;k<9;k++){
                    checkR[k]=0;
                }
                for(int j=0;j<9;j++){
                    if(checkR[arr[i][j]-1]==0){
                        checkR[arr[i][j]-1]=arr[i][j];
                    }
                    else{
                        System.out.print(arr[j][i]);
                        answer=0;
                        break;
                    }

                }
            }
            for(int i=0;i<9;i++){
                int[] checkC=new int[9];
                int flag=0;
                for(int k=0;k<9;k++){
                    checkC[k]=0;
                }
                for(int j=0;j<9;j++){
                    if(checkC[arr[j][i]-1]==0){
                        checkC[arr[j][i]-1]=arr[j][i];
                    }
                    else{
                        System.out.print(arr[j][i]);
                        answer=0;
                        break;
                    }

                }
            }

            for(int i=0;i<9;i+=3){
                for(int j=0;j<9;j+=3){
                    int[] check=new int[9];
                    for(int k=0;k<9;k++){
                        check[k]=0;
                    }
                    for(int ii=0;ii<3;ii++){
                        for(int jj=0;jj<3;jj++){
                            if(check[arr[i+ii][j+jj]-1]==0){
                                check[arr[i+ii][j+jj]-1]=arr[i+ii][j+jj];
                            }
                            else{
                                answer=0;
                                break;
                            }
                        }
                    }

                }
            }
            System.out.printf("#%d %d\n",tc,answer);
        }
    }

}
