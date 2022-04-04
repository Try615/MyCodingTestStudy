package day_220403;

import java.util.*;
import java.io.*;

public class bj_14500 {
	static int N, M;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};

	static int[][] case_r = {{0, -1, -1, -1}, {0, -1, 0, 1}, {0, 1, 1, 1,}, {0, -1, 0, 1}};
	static int[][] case_c = {{0, -1, 0, 1}, {0, 1, 1, 1}, {0, -1, 0, 1}, {0, -1, -1, -1}};
	
	static int[][] field;
	static boolean[][] visited;
	static int result = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
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
				visited[i][j] =  true;
				dfs(i, j, 1, field[i][j]);
				visited[i][j] = false;
				exceptCase(i, j);
			}
		}
		
		System.out.println(result);
		br.close();
	}

	public static void exceptCase(int r, int c) {
		for(int i=0; i<4; i++) {
			int calc = 0;
			for(int dir=0; dir<4; dir++) {
				int ar = r + case_r[i][dir];
				int ac = c + case_c[i][dir];
				
				if(ar >= N || ar < 0 || ac >= M || ac < 0) {
					break;
				}
				
				calc += field[ar][ac];
				
				if(dir == 3) {
					result = Math.max(result, calc);
				}
			}
		}
	}

	public static void dfs(int r, int c, int depth, int value) {
		if(depth >= 4) {
			result = Math.max(result, value);
			return;
		}
		
		for(int dir=0; dir<4; dir++) {
			int ar = r + dr[dir];
			int ac = c + dc[dir];
			
			if(ar >= N || ar < 0 || ac >= M || ac < 0 || visited[ar][ac]) {
				continue;
			}
			
			visited[ar][ac] = true;
			dfs(ar, ac, depth+1, value+field[ar][ac]);
			visited[ar][ac] = false;
		}
	}
}
