import java.io.*;
import java.util.*;


// 백준 1753번. 최단경로.
// 다익스트라 문제. 우선순위 큐 이용.
public class BJ_1753 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int start = Integer.parseInt(br.readLine());
		
		List<int[]>[] list = new ArrayList[V+1];
		int[] distance = new int[V+1];
		for(int i=1; i<=V; i++) {
			list[i] = new ArrayList<>();
			distance[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[from].add(new int[] {to, weight}); 
		}
		
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
				}
			}
		}
		
		for(int i=1; i<=V; i++) {
			if(distance[i] != Integer.MAX_VALUE) {
				sb.append(distance[i]).append("\n");				
			}else {
				sb.append("INF").append("\n");
			}
		}
		
		System.out.println(sb.toString());
		br.close();
	}
}
