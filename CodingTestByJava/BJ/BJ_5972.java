package day_220327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_5972 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<int[]>[] list = new ArrayList[N+1];
		int[] visited = new int[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
			visited[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list[from].add(new int[] {to, cost});
			list[to].add(new int[] {from, cost});
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]> () {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		
		int start = 1;
		pq.offer(new int[] {start, 0});
		visited[1] = 0;
		
		while(!pq.isEmpty()) {
			int[] current = pq.poll();
			int pos = current[0];
			int dist = current[1];
			
			if(visited[pos] < dist) {
				continue;
			}
			
			for(int[] next : list[pos]) {
				int cost = dist + next[1];
				
				if(visited[next[0]] > cost) {
					visited[next[0]] = cost;
					pq.offer(new int[] {next[0], cost});
				}
			}
		}
		
		System.out.println(visited[N]);
		br.close();
	}
}
