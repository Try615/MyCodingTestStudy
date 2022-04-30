package day_220430;

import java.util.*;
import java.io.*;

public class BJ_17070 {
	static int[][] field;
	static int N, result;
	static int[] dr = {0, 0, 1, 1};
	static int[] dc = {0, 1, 1, 0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		
		field = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int j=0; j<N; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		movePipe(0, 1, 1);
		
		System.out.println(result);
		br.close();
	}

	public static void movePipe(int r, int c, int type) {
//		System.out.println(r + " " + c);
		if(r == N-1 && c == N-1) {
			result += 1;
			return;
		}
		
		int[] dirs = null;
		if(type == 1) {
			dirs = new int[] {1, 2};
		}else if(type == 2) {
			dirs = new int[] {1, 2, 3};
		}else if(type == 3) {
			dirs = new int[] {2, 3};
		}
		
		for(int dir : dirs) {
			int ar = r + dr[dir];
			int ac = c + dc[dir];
			
			if(ar >= N || ar < 0 || ac >= N || ac < 0 || field[ar][ac] == 1) {
				continue;
			}
			
			if(dir == 2) {
				if(field[ar-1][ac] == 1 || field[ar][ac-1] == 1) {
					continue;
				}
 			}
			movePipe(ar, ac, dir);
		}
	}
}
