package Java;
import java.util.Scanner;

public class Java0718 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();
        int B=sc.nextInt();
        int N=sc.nextInt();

        int answer=A%B;
        for(int i=0;i<N-1;i++){
            answer*=10;
            answer%=B;
        }
        answer*=10;
        System.out.println(answer/B);
    }
    
}
//