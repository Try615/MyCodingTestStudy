package day_220511;

import java.util.*;
import java.io.*;

// 백준 1197번 최소 스패닝 트리 
// 유니온 파인드를 통한 크루스칼 문제 
public class BJ_1197 {
	static long result;
	static int connect;
	static int[] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		visited = new int[V+1];
		for(int i=0; i<V+1; i++) {
			visited[i] = i;
		}
		
		result = 0;
		connect = 1;

		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			pq.offer(new int[] {from, to, weight});
		}
		
		while(!pq.isEmpty()) {
			if(connect >= V) {
				break;
			}
			
			int[] current = pq.poll();
			
			if(union(current[0], current[1])) {
				result += current[2];
			}
		}
		
		System.out.println(result);
		br.close();
	}
	
	public static boolean union(int a, int b) {
		int a_parent = find(a);
		int b_parent = find(b);
		
		if(a_parent == b_parent) {
			return false;
		}
		
		if(a_parent > b_parent) {
			visited[a_parent] = b_parent;
		}else if(a_parent < b_parent) {
			visited[b_parent] = a_parent;
		}
		
		connect += 1;
		return true;
	}
	
	public static int find(int a) {
		if(visited[a] != a) {
			visited[a] = find(visited[a]);
		}
		return visited[a];
	}
}
