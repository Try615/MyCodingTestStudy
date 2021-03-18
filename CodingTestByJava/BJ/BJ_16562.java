import java.io.*;
import java.util.StringTokenizer;


// 백준 16562. 친구비.
// 서로소 집합 문제.
public class BJ_16562 {
	static class Friend {
		int num;
		int value;
		
		public Friend(int num, int value) {
			super();
			this.num = num;
			this.value = value;
		}
	}
	static int N, M, K;
	static Friend[] friends;
	static boolean[] notPay;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		friends = new Friend[N+1];
		notPay = new boolean[N+1];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=1; i<=N; i++) {
			friends[i] = new Friend(i, Integer.parseInt(st.nextToken()));
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			union(from, to);
		}
		
		int result = 0;
		for(int i=1; i<=N; i++) {
			if(!notPay[i]) {
				result += friends[i].value;
			}
		}
		
		if(K - result < 0) {
			System.out.println("Oh no");
		}else {
			System.out.println(result);
		}
		br.close();
	}

	private static void union(int from, int to) {
		int parentA = find(from);
		int parentB = find(to);
		
		if(friends[parentA].value <= friends[parentB].value) {
			friends[parentB].num = parentA;
			notPay[parentB] = true;
		}else if(friends[parentA].value > friends[parentB].value){
			friends[parentA].num = parentB;
			notPay[parentA] = true;
		}
	}

	private static int find(int idx) {
		if(friends[idx].num != idx) {
			friends[idx].num = find(friends[idx].num);
		}
		return friends[idx].num;
	}
}
