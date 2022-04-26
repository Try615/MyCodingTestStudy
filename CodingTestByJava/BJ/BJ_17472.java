package day_220426;

import java.util.*;
import java.io.*;

public class BJ_17472 {
	static int N, M, result, landIdx, landConnect;
	static int[][] field;
	static boolean[][] visited;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static PriorityQueue<Bridge> pq;
	static int[] check;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		result = 0;
		field = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int j=0; j<M; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		landIdx = 1;
		visited = new boolean[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(field[i][j] == 1 && !visited[i][j]) {
					bfs(new int[] {i, j});
				}
			}
		}
		
		landConnect = landIdx-2;
		pq = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(field[i][j] > 0) {
					makeBridge(field[i][j], new int[] {i, j});
				}
			}
		}
		
		check = new int[landIdx];
		for(int i=1; i<landIdx; i++) {
			check[i] = i;
		}
		
		while(!pq.isEmpty()) {
			Bridge current = pq.poll();
			
			if(union(current.start, current.dest)) {
				result += current.len;
				landConnect -= 1;
			}
			
			if(landConnect <= 0) {
				break;
			}
		}
		
		if(landConnect > 0) {
			result = -1;
		}
		
//		for(int i=0; i<N; i++) {
//			System.out.println(Arrays.toString(field[i]));
//		}
//		
//		System.out.println(Arrays.toString(check));
		
		System.out.println(result);
		br.close();
	}
	
	public static int find(int child) {
		if(check[child] != child) {
			check[child] = find(check[child]);
		}
		return check[child];
	}
	
	public static boolean union(int a, int b) {
		int parentA = find(a);
		int parentB = find(b);
		
		if(parentA == parentB) {
			return false;
		}else {
//			System.out.println(a + " " + b);
			if(parentA < parentB) {
				check[parentB] = parentA;
			}else {
				check[parentA] = parentB;
			}
			return true;
		}
	}
	
	public static class Bridge implements Comparable<Bridge>{
		int start;
		int dest;
		int len;
		
		public Bridge(int start, int dest, int len) {
			this.start = start;
			this.dest = dest;
			this.len = len;
		}
		
		@Override
		public String toString() {
			return start + " " + dest + " " + len;
		}
		
		@Override
		public int compareTo(Bridge o) {
			return Integer.compare(this.len, o.len);
		}
	}
	
	public static void makeBridge(int start, int[] node) {
		for(int dir=0; dir<4; dir++) {
			int ar = node[0];
			int ac = node[1];
			int len = 0;
			
			while(true) {
				ar += dr[dir];
				ac += dc[dir];
				
				if(ar >= N || ar < 0 || ac >= M || ac < 0) {
					break;
				}
				
				if(field[ar][ac] == 0) {
					len += 1;
				}else {
					if(len >= 2) {
						int dest = field[ar][ac];
						
						pq.offer(new Bridge(start, dest, len));
					}
					break;
				}
			}
		}
	}
	
	public static void bfs(int[] node) {
		Deque<int[]> dq = new LinkedList<>();
		field[node[0]][node[1]] = landIdx;
		visited[node[0]][node[1]] = true;
		dq.offer(node);
		
		while(!dq.isEmpty()) {
			int[] current = dq.poll();
			
			for(int dir=0; dir<4; dir++) {
				int ar = current[0] + dr[dir];
				int ac = current[1] + dc[dir];
				
				if(ar >= N || ar < 0 || ac >= M || ac < 0 || visited[ar][ac] || field[ar][ac] == 0) {
					continue;
				}
				
				field[ar][ac] = landIdx;
				visited[ar][ac] = true;
				dq.offer(new int[] {ar, ac});
			}
		}
		
		landIdx += 1;
	}
}
