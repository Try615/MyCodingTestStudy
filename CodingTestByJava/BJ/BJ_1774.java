import java.io.*;
import java.util.*;


// 백준 1774번. 우주신과의 교감.
// 크루스칼. 무향으로 모든 정점이 이어지는 경우이므로 가중치 개별로 계산 필요.
public class BJ_1774 {
	static class Pos{
		int r;
		int c;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		double weight;

		public Edge(int from, int to, double weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.weight, o.weight);
		}
	}
	
	static int notConnect;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Pos[] gods = new Pos[N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			gods[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		List<Edge> list = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			for(int j=i+1; j<=N; j++) {
				double dist = Math.sqrt(Math.pow((gods[i].r - gods[j].r), 2) + Math.pow((gods[i].c - gods[j].c), 2));
				list.add(new Edge(i, j, dist));
			}
		}
		
		Collections.sort(list);
		
		int[] parents = new int[N+1];
		notConnect = N-1;
		for(int i=1; i<=N; i++) {
			parents[i] = i;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			union(parents, from, to);
		}
		
		double result = 0;
		for(Edge e : list) {
			if(union(parents, e.from, e.to)) {
				result += e.weight;
			}
			
			if(notConnect <= 0) {
				break;
			}
		}
		
		System.out.println(String.format("%.2f", result));
		br.close();
	}

	private static boolean union(int[] parents, int from, int to) {
		int parentFrom = find(parents, from);
		int parentTo = find(parents, to);
		
		if(parentFrom != parentTo) {
			if(parentFrom < parentTo) {
				parents[parentTo] = parentFrom;
			}else {
				parents[parentFrom] = parentTo;
			}
			notConnect--;
			return true;
		}
		return false;
	}

	private static int find(int[] parents, int node) {
		if(parents[node] != node) {
			parents[node] = find(parents, parents[node]);
		}
		return parents[node];
	}
}
