package day_220322;

import java.util.*;
import java.io.*;

public class bj_13460 {
	public static class Ball{
		char type;
		int r;
		int c;
		int changeDir;
		int beforeDir;
		
		public Ball(char type, int r, int c, int changeDir, int beforeDir) {
			this.type = type;
			this.r = r;
			this.c = c;
			this.changeDir = changeDir;
			this.beforeDir = beforeDir;
		}
	}
	
	public static int[] dr = {0, 1, 0, -1};
	public static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Deque<Ball> dq = new LinkedList<>();
		
		int result = Integer.MAX_VALUE;
		
		char[][] field = new char[N][M];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			
			for(int j=0; j<M; j++) {
				char c = s.charAt(j);
				
				if(c == 'R') {
					Ball red = new Ball('R', i, j, 0, -1);
//					System.out.println("red : " + i + " " + j);
					dq.offer(red);
					c = '.';
				}else if(c == 'B') {
					Ball blue = new Ball('B', i, j, 0, -1);
//					System.out.println("blue : " + i + " " + j);
					dq.offer(blue);
					c = '.';
				}
				field[i][j] = c;
			}
		}
		
		while(!dq.isEmpty()) {
			if(result != Integer.MAX_VALUE) {
				break;
			}
			
			Ball red = null;
			Ball blue = null;
			if(dq.peek().type == 'R') {
				red = dq.poll();
				blue = dq.poll();
			}else {
				blue = dq.poll();
				red = dq.poll();
			}
			
			for(int dir=0; dir<4; dir++) {
				boolean red_stuck = false;
				boolean blue_stuck = false;
				
				boolean red_hole = false;
				boolean blue_hole = false;
				int red_ar = red.r;
				int red_ac = red.c;
				int blue_ar = blue.r;
				int blue_ac = blue.c;
				
				if(red.beforeDir == dir && blue.beforeDir == dir) {
					continue;
				}
				
//				System.out.println("Dir : " + dir);
				while(!(red_stuck && blue_stuck)) {
					if(!red_stuck) {
						if(field[red_ar+dr[dir]][red_ac+dc[dir]] == 'O') {
							red_ar += dr[dir];
							red_ac += dc[dir];
							red_stuck = true;
							red_hole = true;
							continue;
						}else if(red_ar + dr[dir] == blue_ar && red_ac + dc[dir] == blue_ac){
							red_stuck = true;
							continue;
						}else if(field[red_ar+dr[dir]][red_ac+dc[dir]] == '#') {
							red_stuck = true;
							continue;
						}
						red_ar += dr[dir];
						red_ac += dc[dir];
//						System.out.println("red ar ac : " + red_ar + " " + red_ac);
					}else {
						if(!red_hole && field[red_ar+dr[dir]][red_ac+dc[dir]] != '#' && (red_ar+dr[dir] != blue_ar || red_ac+dc[dir] != blue_ac)) {
							red_stuck = false;
						}
					}
					
					if(!blue_stuck) {
						if(field[blue_ar+dr[dir]][blue_ac+dc[dir]] == 'O') {
							blue_ar += dr[dir];
							blue_ac += dc[dir];
							blue_stuck = true;
							blue_hole = true;
							continue;
						}else if(blue_ar + dr[dir] == red_ar && blue_ac + dc[dir] == red_ac){
							blue_stuck = true;
							continue;
						}else if(field[blue_ar+dr[dir]][blue_ac+dc[dir]] == '#') {
							blue_stuck = true;
							continue;
						}
						blue_ar += dr[dir];
						blue_ac += dc[dir];
//						System.out.println("blue ar ac : " + blue_ar + " " + blue_ac);
					}else {
						if(!blue_hole && field[blue_ar+dr[dir]][blue_ac+dc[dir]] != '#' && (blue_ar +dr[dir] != red_ar || blue_ac +dc[dir] != red_ac)) {
							blue_stuck = false;
						}
					}
				}
				
				int red_changeDir = red.changeDir + 1;
				int blue_changeDir = blue.changeDir + 1;
				
//				System.out.println("hole - red : " + red_hole + "  blue : " + blue_hole  );
				if(red_changeDir > 10 || blue_changeDir > 10) {
					continue;
				}
				
				if(blue_hole) {
					continue;
				}else if(red_hole) {
					result = Math.min(result, red_changeDir);
					break;
				}
				
//				System.out.println("새로운 공 ");
				dq.offer(new Ball('R', red_ar, red_ac, red_changeDir, dir));
				dq.offer(new Ball('B', blue_ar, blue_ac, blue_changeDir, dir));
			}
		}
		
		if(result == Integer.MAX_VALUE) {
			result = -1;
		}
		System.out.println(result);
		br.close();
	}
}