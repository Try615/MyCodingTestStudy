import java.io.*;
import java.util.*;

// 백준 11779번. 최소 비용 구하기2.
// 다익스트라 + 경로 구하기.
public class BJ_11779 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		List<int[]>[] list = new ArrayList[N+1];
		int[] distance = new int[N+1];
		int[] parent = new int[N+1];
		Deque<Integer> route = new LinkedList<Integer>();
		
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
			distance[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[from].add(new int[] {to, weight}); 
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		pq.offer(new int[] {0, start});
		distance[start] = 0;
		
		while(!pq.isEmpty()) {
			int[] temp = pq.poll();
			
			int dist = temp[0];
			int node = temp[1];
			
			if(distance[node] < dist) {
				continue;
			}
			
			for(int[] next : list[node]) {
				int cost = dist + next[1];
				
				if(cost < distance[next[0]]) {
					distance[next[0]] = cost;
					pq.offer(new int[] {distance[next[0]], next[0]});
					
					parent[next[0]] = node;
				}
			}
		}
		
		int current = end;
		while(current != start) {
			route.addFirst(current);
			
			current = parent[current];
		}
		route.addFirst(start);
		
		System.out.println(distance[end]);
		System.out.println(route.size());
		for(int i : route) {
			System.out.print(i + " ");
		}
		br.close();
	}
}
