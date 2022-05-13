package day_220513;

import java.util.*;
import java.io.*;


// 백준 16973 직사각형 탈출.
// BFS로 문제풀이를 시도하니 통과는 했지만 메모리 약 120MB, 시간 4912ms.
// 이를 해결하기위해 누적합으로 재풀이. (메모리는 변함없음)

public class BJ_16973 {
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] field = new int[N+1][M+1];
		boolean[][] visited = new boolean[N+1][M+1];
		int[][] prefixSum = new int[N+1][M+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int j=1; j<=M; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
				prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1] + field[i][j];
			}
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int destR = Integer.parseInt(st.nextToken());
		int destC = Integer.parseInt(st.nextToken());
		
		int[] start = new int[] {r, c, 0};
		
		Deque<int[]> dq = new LinkedList<>();
		dq.offer(start);
		visited[r][c] = true;
		
		int result = -1;
		
		while(!dq.isEmpty()) {
			int[] current = dq.poll();
			
//			System.out.println(current[0] + " " + current[1] + " " + current[2]);
			
			if(current[0] == destR && current[1] == destC) {
				result = current[2];
				break;
			}
			
			for(int dir=0; dir<4; dir++) {
				int ar = current[0] + dr[dir];
				int ac = current[1] + dc[dir];
				
				if(ar > N-H+1 || ar < 1 || ac > M-W+1 || ac < 1 || visited[ar][ac]) {
					continue;
				}
				
				
				// 누적합 사용 이전 완탐.
//				boolean check = false;
//				for(int i=ar; i<ar+H; i++) {
//					if(check) {
//						break;
//					}
//					
//					for(int j=ac; j<ac+W; j++) {
//						if(field[i][j] == 1) {
//							check = true;
//							break;
//						}
//					}
//				}

				if(prefixSum[ar+H-1][ac+W-1] - prefixSum[ar+H-1][ac-1] - prefixSum[ar-1][ac+W-1] + prefixSum[ar-1][ac-1] == 0) {
					visited[ar][ac] = true;
					dq.offer(new int[] {ar, ac, current[2]+1});
				}
			}
		}
		
		System.out.println(result);
		br.close();
	}
}
