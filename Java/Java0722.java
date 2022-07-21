package Java;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java0722 {
    public static void main(String[] args)throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(in.readLine()); //test cast
        StringTokenizer st=new StringTokenizer(in.readLine()," ");
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;

        for(int i=0;i<N;i++){    
            int num=Integer.parseInt(st.nextToken());
            max= num>max ? num:max;
            min=num<min?num:min;

        }
        System.out.println(max*min);
        
    }
    
}
