import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_11286_절댓값힘 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if(Math.abs(o1)==Math.abs(o2)) return o1-o2;
				return Math.abs(o1)-Math.abs(o2);
			}
			
		});
		for(int i=0;i<N;i++) {
			int input = Integer.parseInt(in.readLine());
			if(input == 0) {
				if(queue.size()==0) sb.append(0).append("\n");
				else sb.append(queue.poll()).append("\n");
			}
			else {				
				queue.add(input);
			}
			
		}
		System.out.println(sb);
	}
}
