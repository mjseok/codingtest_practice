package Java;
import java.util.Scanner;

public class Java0719 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        
        int group=0;
        
        for(int i=0;i<N;i++){
            String word=sc.next();
            boolean[] check=new boolean[26];//알파벳
            boolean result=true;
            for(int j=0;j<word.length();j++){
                int idx=word.charAt(j)-'a';
                if(check[idx]){
                    if(word.charAt(j)!=word.charAt(j-1)){
                        result=false;
                        break;
                    }
                }
                else{
                    check[idx]=true;
                }
            }
            if(result){
                group++;
            } 
        }
        System.out.println(group);
    }
    
}
