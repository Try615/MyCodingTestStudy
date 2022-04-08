package day_220408;

import java.util.*;
import java.io.*;

public class pg_행렬테두리회전하기 {
	public static void main(String[] args) throws Exception{
		int rows = 6;
		int columns = 6;
		int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6,}, {5, 1, 6, 3}};
		
		int[] result = solution(rows, columns, queries);
		System.out.println(Arrays.toString(result));
	}
	
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static int[] solution(int rows, int columns, int[][] queries) {
		int[][] field = new int[rows][columns];
		int[] result = new int[queries.length];
		
		for(int i=0; i<rows; i++) {
			for(int j=0; j<columns; j++) {
				field[i][j] = i*columns + j+1;
			}
		}
		
		int idx = 0;
		for(int[] query : queries) {
			int r1 = query[0]-1;
			int c1 = query[1]-1;
			int r2 = query[2]-1;
			int c2 = query[3]-1;
			
			int min = Integer.MAX_VALUE;
			int temp = field[r1][c1];
			min = Math.min(min, temp);
			
			int[][] point = {{r1, c1}, {r2, c1}, {r2, c2}, {r1, c2}};
			
			
			for(int dir=0; dir<4; dir++) {
				int r = point[dir][0];
				int c = point[dir][1];

				while(true) {
					int ar = r + dr[dir];
					int ac = c + dc[dir];
					
					if(ar > r2 || ar < r1 || ac > c2 || ac < c1) {
						break;
					}
					
					field[r][c] = field[ar][ac];
					min = Math.min(min, field[r][c]);
					r = ar;
					c = ac;
				}

				if(dir == 3) {
					field[point[0][0]][point[0][1]+1] = temp;
				}
			}
			
			result[idx++] = min;
		}
		
		return result;
	}
}
