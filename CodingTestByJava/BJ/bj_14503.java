package day_220413;

import java.util.*;
import java.io.*;

public class bj_14503 {
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static class Node{
		int r;
		int c;
		int d;
		int stay;
		
		public Node(int r, int c, int d, int stay) {
			this.r = r;
			this.c = c;
			this.d = d;
			this.stay = stay;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		int[][] field = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int j=0; j<M; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int result = 0;

		Queue<Node> q = new LinkedList<>();
		Node start = new Node(r, c, d, 0);
		q.offer(start);
		
		while(!q.isEmpty()) {
			Node current = q.poll();
			
//			System.out.println(current.r + " " + current.c + " " + current.d + " " + current.stay);
			
			if(current.stay >= 4) {
				int oppoDir = (current.d - 2 >= 0)? current.d-2 : current.d+2;
				
				int backR = current.r + dr[oppoDir];
				int backC = current.c + dc[oppoDir];
				
				if(field[backR][backC] == 1) {
					break;
				}else {
					q.offer(new Node(backR, backC, current.d, 0));
					continue;
				}
			}
			
			if(field[current.r][current.c] == 0) {
				field[current.r][current.c] = 2;
				result += 1;
			}
			
			int nextDir = (current.d-1 >= 0)? current.d-1 : 3;
			
			int ar = current.r + dr[nextDir];
			int ac = current.c + dc[nextDir];
			
			if(field[ar][ac] == 0) {
				q.offer(new Node(ar, ac, nextDir, 0));
			}else {
				q.offer(new Node(current.r, current.c, nextDir, current.stay+1));
			}
		}
		
		
		System.out.println(result);
		br.close();
	}
}
