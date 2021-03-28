import java.io.*;
import java.util.*;


// 백준 2638번. 치즈.
// BFS. 방문을 int로 하여 횟수 처리.
public class BJ_2638 {
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int totalCheeseCount = 0;
		int[][] field = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
				if(field[i][j] == 1) {
					totalCheeseCount++;
				}
			}
		}
		
		Deque<int[]> dq = new LinkedList<int[]>();
		
		int timeCount = 0;
		while(totalCheeseCount > 0) {
			int[][] visited = new int[N][M];
			int[] start = {0, 0};
			visited[0][0] += 1;
			int cheeseCount = 0;
			
			dq.offer(start);
			
			while(!dq.isEmpty()) {
				int[] current = dq.poll();
				int r = current[0];
				int c = current[1];
				
				for(int dir=0; dir<4; dir++) {
					int ar = r + dr[dir];
					int ac = c + dc[dir];
					
					if(ar < 0 || ar >= N || ac < 0 || ac >= M) {
						continue;
					}
					
					visited[ar][ac] += 1;
					
					if(field[ar][ac] == 0) {
						if(visited[ar][ac] == 1) {
							dq.offer(new int[] {ar, ac});
						}
					}else {
						if(field[ar][ac] == 1 && visited[ar][ac] == 2) {
							field[ar][ac] = 0;
							cheeseCount++;
						}
					}
				}
			}
			timeCount++;
			totalCheeseCount -= cheeseCount;
		}
		
		System.out.println(timeCount);
	}
}
