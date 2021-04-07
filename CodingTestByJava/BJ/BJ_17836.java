import java.io.*;
import java.util.*;

public class BJ_17836 {
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int N, M, T;
	static int resultTime = Integer.MAX_VALUE;
	static int[][] castle;
	static boolean[][] visited;
	static Deque<Player> dq = new LinkedList<Player>();
	
	static class Player{
		int r;
		int c;
		int time;
		boolean wallBreakable;
		
		public Player(int r, int c, int time, boolean wallBreakable) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
			this.wallBreakable = wallBreakable;
		}

		@Override
		public String toString() {
			return "Player [r=" + r + ", c=" + c + ", time=" + time + ", wallBreakable=" + wallBreakable + "]";
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		castle = new int[N][M];
		visited= new boolean[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				castle[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Player player = new Player(0, 0, 0, false);
		visited[0][0] = true;
		
		bfs(player);
		
		if(resultTime == Integer.MAX_VALUE || resultTime > T) {
			System.out.println("Fail");
		}else {
			System.out.println(resultTime);
		}
		br.close();
	}

	private static void bfs(Player player) {
		dq.add(player);
		
		while(!dq.isEmpty()) {
			Player node = dq.poll();
			
			if(node.time > T) {
				return;
			}
			
			if(node.r == N-1 && node.c == M-1) {
				resultTime = Math.min(resultTime, node.time);
				return;
			}
			
			for(int dir=0; dir<4; dir++) {
				int ar = node.r + dr[dir];
				int ac = node.c + dc[dir];
				
				if(ar < 0 || ar >= N || ac < 0 || ac >= M || visited[ar][ac]) {
					continue;
				}
				
				if(castle[ar][ac] == 1) {
					continue;
				}else if(castle[ar][ac] == 2) {
//					dq.add(new Player(ar, ac, node.time+1, true));
					resultTime = Math.min(resultTime, node.time + 1 + (N-1 - ar) + (M-1 - ac));
				}else {
					dq.add(new Player(ar, ac, node.time+1, node.wallBreakable));
				}
				visited[ar][ac] = true;
			}
		}
	}
}
