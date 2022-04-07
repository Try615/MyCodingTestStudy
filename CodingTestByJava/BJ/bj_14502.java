package day_220407;

import java.util.*;
import java.io.*;

// 백준 14502 '연구소' 
public class bj_14502 {
	static int result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		result = Integer.MIN_VALUE;
		
		int[][] field = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int j=0; j<M; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		makeWall(field, 3);
		
		System.out.println(result);
		br.close();
	}

	public static void makeWall(int[][] field, int wall) {
		if(wall <= 0) {
			bfs(field);
			return;
		}
		
		int N = field.length;
		int M = field[0].length;

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(field[i][j] == 0) {
					field[i][j] = 1;
					makeWall(field, wall - 1);
					field[i][j] = 0;
				}
			}
		}
	}
	
	public static void bfs(int[][] field) {
		int N = field.length;
		int M = field[0].length;
		
		int[][] cl = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				cl[i][j] = field[i][j];
			}
		}
		
		int[] dr = {0, 1, 0, -1};
		int[] dc = {1, 0, -1, 0};
		
		Queue<int[]> q = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(cl[i][j] == 2) {
					q.offer(new int[] {i, j});
				}
			}
		}
		
		while(!q.isEmpty()) {
			int[] current = q.poll();
			
			for(int dir=0; dir<4; dir++) {
				int ar = current[0]	+ dr[dir];
				int ac = current[1] + dc[dir];
				
				if(ar >= N || ar < 0 || ac >= M || ac < 0 || cl[ar][ac] != 0) {
					continue;
				}

				cl[ar][ac] = 2;
				q.offer(new int[] {ar, ac});
			}
		}
		
		int calc = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(cl[i][j] == 0) {
					calc += 1;
				}
			}
		}
		
//		if(result < calc) {
//			System.out.println("----------------------");
//			for(int i=0; i<N; i++) {
//				System.out.println(Arrays.toString(field[i]));
//			}
//			System.out.println("----------------------");
//		}
		
		result = Math.max(result, calc);
	}
}
