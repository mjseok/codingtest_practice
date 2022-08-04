import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2164.java {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		Queue<Integer> card = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=N;i++) {
			card.offer(i);
		}
		System.out.println(card);
		while(true) {
			if(card.size()==1) {
				sb.append(card.poll());
				break;
			}
			card.poll();
			int tmp=card.poll();
			card.offer(tmp);
		}
		System.out.println(sb);
		
	}
}
