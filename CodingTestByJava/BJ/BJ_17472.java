import java.io.*;
import java.util.*;


// 백준 17472번. 다리 만들기 2.
// BFS로 섬을 넘버링 후, 모든 위치에서 사방 탐색하여 간선 정보 획득. 크루스칼.
public class BJ_17472 {
	static int N, M, landIdx, result;
	static int[][] field;
	static boolean[][] visited;
	static int landConnect;
	
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		landIdx = 1;
		result = 0;
		
		field = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(field[i][j] == 1 && !visited[i][j]) {
					bfs(new int[] {i, j});
				}
			}
		}
		
		int[] parents = new int[landIdx];
		for(int i=1; i<landIdx; i++) {
			parents[i] = i;
		}
		
		List<Edge> list = new ArrayList<Edge>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(field[i][j] != 0) {
					int from = field[i][j];
					for(int dir=0; dir<4; dir++) {
						int ar = i;
						int ac = j;
						int lenCount = 0;
						
						while(true) {
							ar += dr[dir];
							ac += dc[dir];
							
							if(ar < 0 || ar >= N || ac < 0 || ac >= M) {
								break;
							}
							
							if(field[ar][ac] != 0) {
								if(field[ar][ac] != from && lenCount > 1) {
									int to = field[ar][ac];
									list.add(new Edge(from, to, lenCount));
								}
								break;
							}
							lenCount++;
						}
					}
				}
			}
		}
		Collections.sort(list);
		
		landConnect = landIdx-2;
		for(Edge e : list) {
			int parentFrom = find(parents, e.from);
			int parentTo = find(parents, e.to);
			
			if(parentFrom != parentTo) {
				union(parents, parentFrom, parentTo);
				result += e.weight;
				landConnect--;
			}
			
			if(landConnect <= 0) {
				break;
			}
		}
		
		if(landConnect <= 0) {
			System.out.println(result);
		}else {
			System.out.println(-1);
		}
		br.close();
	}
	
	
	private static int find(int[] parents, int node) {
		if(parents[node] != node) {
			parents[node] = find(parents, parents[node]);
		}
		return parents[node];
	}



	private static void union(int[] parents, int parentFrom, int parentTo) {
		if(parentFrom < parentTo) {
			parents[parentTo] = parentFrom;
		}else {
			parents[parentFrom] = parentTo; 
		}
	}


	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int weight;
		
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}
		
	}

	private static void bfs(int[] start) {
		Deque<int[]> dq = new LinkedList<int[]>();
		dq.offer(start);
		visited[start[0]][start[1]] = true;
		field[start[0]][start[1]] = landIdx;
		
		while(!dq.isEmpty()) {
			int[] current = dq.poll();
			int r = current[0];
			int c = current[1];
			
			for(int dir=0; dir<4; dir++) {
				int ar = r + dr[dir];
				int ac = c + dc[dir];
				
				if(ar < 0 || ar >= N || ac < 0 || ac >= M || visited[ar][ac] || field[ar][ac] == 0) {
					continue;
				}
				
				visited[ar][ac] = true;
				dq.offer(new int[] {ar, ac});
				field[ar][ac] = landIdx;
			}
		}
		landIdx++;
	} 
}
