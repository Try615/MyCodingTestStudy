package day_220430;

import java.util.*;
import java.io.*;

public class BJ_17281 {
	static int result, N;
	static int[][] players;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		
		players = new int[N][9];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int j=0; j<9; j++) {
				players[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		result = 0;
		
		makePermutation(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8}, 0, new int[9], new boolean[9]);

		System.out.println(result);
		br.close();
	}

	public static void makePermutation(int[] arr, int idx, int[] selected, boolean[] checked) {
		if(idx > 3 && selected[3] != 0) {
			return;
		}
		
		if(idx >= selected.length) {
			play(selected);
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(!checked[i]) {
				checked[i] = true;
				selected[idx] = arr[i];
				makePermutation(arr, idx+1, selected, checked);
				checked[i] = false;
			}
		}
	}

	public static void play(int[] selected) {
		int calc = 0;
		
		int idx = 0;
		int player = selected[idx];
		for(int e=0; e<N; e++) {
			boolean[] field = new boolean[3];
			int outCount = 0;
			
			while(outCount < 3) {
				int rec = players[e][player];
				
				if(rec == 1) {
					if(field[2]) {
						calc += 1;
						field[2] = false;
					}
					for(int i=2; i>0; i--) {
						field[i] = field[i-1];
					}
					field[0] = true;
				}else if(rec == 2) {
					if(field[2]) {
						calc += 1;
						field[2] = false;
					}
					if(field[1]) {
						calc += 1;
						field[1] = false;
					}
					for(int i=2; i>1; i--) {
						field[i] = field[i-2];
					}
					field[0] = false;
					field[1] = true;
				}else if(rec == 3) {
					if(field[2]) {
						calc += 1;
						field[2] = false;
					}
					if(field[1]) {
						calc += 1;
						field[1] = false;
					}
					if(field[0]) {
						calc += 1;
						field[0] = false;
					}
					field[2] = true;
				}else if(rec == 4) {
					if(field[2]) {
						calc += 1;
						field[2] = false;
					}
					if(field[1]) {
						calc += 1;
						field[1] = false;
					}
					if(field[0]) {
						calc += 1;
						field[0] = false;
					}
					calc += 1;
				}else if(rec == 0) {
					outCount += 1;
				}
				
				idx = idx + 1 >= 9? 0:idx+1;
				player = selected[idx];
			}
		}
		
		result = Math.max(result, calc);
	}
}
