package day_220331;

import java.util.*;
import java.io.*;

public class bj_14499 {
	
	static int[] dr = {0, 0, 0, -1, 1};
	static int[] dc = {0, 1, -1, 0, 0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] field = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int j=0; j<M; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dice = new int[3][3];
		int diceTop = 0;
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<K; i++) {
			int dir = Integer.parseInt(st.nextToken());
			
			if(r + dr[dir] >= N || r + dr[dir] < 0 || c + dc[dir] >= M || c + dc[dir] < 0) {
				continue;
			}
			
			r += dr[dir];
			c += dc[dir];
			
			int temp = diceTop;
			if(dir == 1) {
				diceTop = dice[1][0];
				dice[1][0] = dice[1][1];
				dice[1][1] = dice[1][2];
				dice[1][2] = temp;
			}else if(dir == 2) {
				diceTop = dice[1][2];
				dice[1][2] = dice[1][1];
				dice[1][1] = dice[1][0];
				dice[1][0] = temp;
			}else if(dir == 3) {
				diceTop = dice[2][1];
				dice[2][1] = dice[1][1];
				dice[1][1] = dice[0][1];
				dice[0][1] = temp;
			}else if(dir == 4) {
				diceTop = dice[0][1];
				dice[0][1] = dice[1][1];
				dice[1][1] = dice[2][1];
				dice[2][1] = temp;
			}
			
			if(field[r][c] == 0) {
				field[r][c] = dice[1][1];
			}else {
				dice[1][1] = field[r][c];
				field[r][c] = 0;
			}
			
			sb.append(diceTop);
			if(i != K-1) {
				sb.append("\n");
			}
		}
		
		System.out.println(sb.toString());
		br.close();
	}
}
