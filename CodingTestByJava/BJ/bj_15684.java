package day_220414;

import java.util.*;
import java.io.*;

public class bj_15684 {
	static int[][] field;
	static int result, N, M, H;
	static boolean trigger;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		field = new int[H+1][N+1];
		trigger = false;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
		
			field[a][b] = 1;
			field[a][b+1] = 2;
		}
		
		for(result=0; result<4; result++) {
			makeLadder(1, 1, 0);
			if(trigger) {
				break;
			}
		}

		result = (result >= 4)? -1 : result;
		System.out.println(result);
		br.close();
	}
	
	public static void makeLadder(int col, int row, int count) {
		if(trigger) {
			return;
		}
		if(result <= count){
			if(check()) {
				trigger = true;
			}
			return;
		}
		
		for(int i=col; i<N; i++) {
			for(int j=1; j<=H; j++) {
				if(field[j][i] == 0 && field[j][i+1] == 0) {
					field[j][i] = 1;
					field[j][i+1] = 2;
					makeLadder(i, j, count+1);
					field[j][i] = field[j][i+1] = 0;
				}
			}
		}
	}
	
	public static boolean check() {
		for(int i=1; i<=N; i++) {
			int node = i;
			for(int j=1; j<=H; j++) {
				if(field[j][node] == 1) {
					node += 1;
				}else if(field[j][node] == 2) {
					node -= 1;
				}
			}
			if(node != i) {
				return false;
			}
		}
		
		return true;
	}
}
