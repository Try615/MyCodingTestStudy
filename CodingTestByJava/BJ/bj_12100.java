package day_220329;

import java.util.*;
import java.io.*;

public class bj_12100 {
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int N, result;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		
		int[][] field = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int j=0; j<N; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs(field, 0);
		System.out.println(result);
		br.close();
		
	}

	public static void bfs(int[][] field, int changeDir) {
		if(changeDir >=5 ) {
			int max = Integer.MIN_VALUE;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					max = Math.max(max, field[i][j]);
				}
			}
			
			result = Math.max(result, max);
			
			return;
		}
		
		for(int dir=0; dir<4; dir++) {
			int[][] leaf = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					leaf[i][j] = field[i][j];
				}
			}
			
			// 이동하고, 합치고, 합칠 수 없을 때 종료.
			boolean moveFirst = false;
			while(!moveFirst) {
				moveFirst = true;
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(leaf[i][j] == 0) {
							continue;
						}
						
						int ar = i;
						int ac = j;
						
						while(true) {
							ar += dr[dir];
							ac += dc[dir];
							
							if(ar >= N || ar < 0 || ac >= N || ac < 0) {
								break;
							}
							
							if(leaf[ar][ac] != 0 ) {
								break;
							}
							
							leaf[ar][ac] = leaf[ar - dr[dir]][ac - dc[dir]];
							leaf[ar - dr[dir]][ac - dc[dir]] = 0;
							moveFirst = false;
						}
					}
				}
			}
			
			if(dir == 0) {
				for(int i=0; i<N; i++) {
					for(int j=N-1; j>=1; j--) {
						if(leaf[i][j] != 0 && leaf[i][j] == leaf[i][j-1]) {
							leaf[i][j] *= 2;
							leaf[i][j-1] = 0;
						}
					}
				}
			}else if(dir == 1) {
				for(int j=0; j<N; j++) {
					for(int i=N-1; i>=1; i--) {
						if(leaf[i][j] != 0 && leaf[i][j] == leaf[i-1][j]) {
							leaf[i][j] *= 2;
							leaf[i-1][j] = 0;
						}
					}
				}
			}else if(dir == 2) {
				for(int i=0; i<N; i++) {
					for(int j=0; j<N-1; j++) {
						if(leaf[i][j] != 0 && leaf[i][j] == leaf[i][j+1]) {
							leaf[i][j] *= 2;
							leaf[i][j+1] = 0;
						}
					}
				}
			}else if(dir == 3) {
				for(int j=0; j<N; j++) {
					for(int i=0; i<N-1; i++) {
						if(leaf[i][j] != 0 && leaf[i][j] == leaf[i+1][j]) {
							leaf[i][j] *= 2;
							leaf[i+1][j] = 0;
						}
					}
				}
			}
			
			boolean moveSecond = false;
			while(!moveSecond) {
				moveSecond = true;
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(leaf[i][j] == 0) {
							continue;
						}
						
						int ar = i;
						int ac = j;
						
						while(true) {
							ar += dr[dir];
							ac += dc[dir];
							
							if(ar >= N || ar < 0 || ac >= N || ac < 0) {
								break;
							}
							
							if(leaf[ar][ac] != 0 ) {
								break;
							}
							
							leaf[ar][ac] = leaf[ar - dr[dir]][ac - dc[dir]];
							leaf[ar - dr[dir]][ac - dc[dir]] = 0;
							moveSecond = false;
						}
					}
				}
			}
			
			bfs(leaf, changeDir + 1);
			
		}
	}
}
