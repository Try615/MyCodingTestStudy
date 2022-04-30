package day_220430;

import java.util.*;
import java.io.*;

public class BJ_17136 {
	static int[][] field;
	static int[] numPaper;
	static int result, N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = 10;
		field = new int[N][N];
		result = Integer.MAX_VALUE;
		
		numPaper = new int[] {5, 5, 5, 5, 5};
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int j=0; j<N; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0, 0);
		
		result = result==Integer.MAX_VALUE? -1 : result;
		System.out.println(result);
		br.close();
	}

	public static void dfs(int r, int c, int numUsed) {
		if(r == N-1 && c == N) {
			result = Math.min(result, numUsed);
			return;
		}
		
		if(numUsed >= result) {
			return;
		}
		
		if(c >= N) {
			dfs(r+1, 0, numUsed);
			return;
		}
		
		if(field[r][c] == 1) {
			for(int s=4; s>=0; s--) {
				if(numPaper[s] > 0 && canAttach(r, c, s+1)) {
					numPaper[s] -= 1;
					attach(r, c, s+1);
					dfs(r, c+1, numUsed+1);
					dettach(r, c, s+1);
					numPaper[s] += 1;
				}
			}
		}else {
			dfs(r, c+1, numUsed);
		}
	}

	public static void dettach(int r, int c, int size) {
		for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				field[i][j] = 1;
			}
		}
	}

	public static void attach(int r, int c, int size) {
		for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				field[i][j] = 0;
			}
		}
	}

	public static boolean canAttach(int r, int c, int size) {
		if(r + size-1 >= N || c + size-1 >= N) {
			return false;
		}
		
		for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				if(field[i][j] != 1) {
					return false;
				}
			}
		}
		
		return true;
	}
}
