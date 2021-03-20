import java.io.*;
import java.util.*;

// 백준 15787번. 기차가 어둠을 헤치고 은하수를.
// 비트마스킹, 구현 문제.
public class BJ_15787 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		Set<Integer> pass = new HashSet<>();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] trains = new int[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int order = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());
			int seat = 0;
			
			switch(order) {
			case 1:
				seat = Integer.parseInt(st.nextToken());
				trains[target] |= (1<<seat-1);
				break;
			case 2:
				seat = Integer.parseInt(st.nextToken());
				trains[target] &= ~(1<<seat-1);
				break;
			case 3:
				trains[target] <<= 1;
				if(trains[target] >= (int)(Math.pow(2, 20))) {
					trains[target] -= (int)(Math.pow(2, 20));
				}
				break;
			case 4:
				trains[target] >>= 1;
				break;
			default:
				break;
			}
		}
		
		for(int i=1; i<N+1; i++) {
			pass.add(trains[i]);
		}
		
		System.out.println(pass.size());
		br.close();
	}
}
