package day_220425;

import java.util.*;
import java.io.*;

public class bj_20057 {
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {-1, 0, 1, 0};
	static int[][] dia_r = {{-1, 1, 1, -1}, {1, 1, -1, -1}, {1, -1, -1, 1}, {-1, -1, 1, 1}};
	static int[][] dia_c = {{-1, -1, 1, 1}, {-1, 1, 1, -1}, {1, 1, -1, -1}, {1, -1, -1, 1}};
	static int[][] field;
	static int N, result;
	
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
		
		result = 0;
		
		int r = N/2;
		int c = N/2;
		int dir = 0;
		int move = 0;
		boolean done = false;
		
		while(!done) {
			if(dir % 2 == 0 && move < N) {
				move += 1;
			}
			
			for(int m=0; m<move; m++) {
				r += dr[dir];
				c += dc[dir];
				
				transferSend(r, c, dir);
				
				if(r == 0 && c == 0) {
					done = true;
					break;
				}
			}
			
			dir = dir + 1 >= 4 ? 0 : dir+1; 
		}
		
		System.out.println(result);
		br.close();
	}
	
	public static void transferSend(int r, int c, int dir) {
		int currentSend = field[r][c];
		int send_10 = (int)Math.floor((double)currentSend * 0.1);
		int send_7 = (int)Math.floor((double)currentSend * 0.07);
		int send_5 = (int)Math.floor((double)currentSend * 0.05);
		int send_2 = (int)Math.floor((double)currentSend * 0.02);
		int send_1 = (int)Math.floor((double)currentSend * 0.01);
		int a = currentSend - 2*(send_10 + send_7 + send_2 + send_1) - send_5;
		
		for(int d=0; d<4; d++) {
			int ar = r;
			int ac = c;
			
			if(d == dir) {
				for(int i=0; i<2; i++) {
					ar += dr[d];
					ac += dc[d];
					
					if(ar < N && ar >= 0 && ac < N && ac >= 0) {
						if(i==0) {
							field[ar][ac] += a;
						}else if(i==1) {
							field[ar][ac] += send_5;
						}
					}else {
						if(i==0) {
							result += a;
						}else if(i==1) {
							result += send_5;
						}
					}
				}
			}else if(d == (dir+2>=4? dir+2-4:dir+2)) {
				continue;
			}else {
				for(int i=0; i<2; i++) {
					ar += dr[d];
					ac += dc[d];
					
					if(ar < N && ar >= 0 && ac < N && ac >= 0) {
						if(i==0) {
							field[ar][ac] += send_7;
						}else if(i==1) {
							field[ar][ac] += send_2;
						}
					}else {
						if(i==0) {
							result += send_7;
						}else if(i==1) {
							result += send_2;
						}
					}
				}
			}
		}
		
		for(int d=0; d<4; d++) {
			int ar = r + dia_r[dir][d];
			int ac = c + dia_c[dir][d];
			
			if(ar < N && ar >= 0 && ac < N && ac >= 0) {
				if(d <= 1) {
					field[ar][ac] += send_10;
				}else {
					field[ar][ac] += send_1;
				}
			}else {
				if(d <= 1) {
					result += send_10;
				}else {
					result += send_1;
				}
			}
		}
		
//		field[r][c] = 0;
//		
//		System.out.println(r + " " + c + " " + result + "----------------------");
//		for(int i=0; i<N; i++) {
//			System.out.println(Arrays.toString(field[i]));
//		}
	}
}
