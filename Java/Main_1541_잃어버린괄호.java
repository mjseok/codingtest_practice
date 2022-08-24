import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1541_잃어버린괄호 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str=in.readLine();
		Queue<String> queue = new LinkedList<>();
		String num="";
		for(int i=0;i<str.length();i++) {
			char input = str.charAt(i);
			if(0<input-'0'&&input-'0'<=9) {
				num+=input;
			}
			else {
				queue.add(num);
				num="";
				queue.add(input+"");
			}
		}
		
	}
}
