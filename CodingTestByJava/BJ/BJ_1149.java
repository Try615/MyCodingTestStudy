package com.ssafy.algo0323;

import java.io.*;
import java.util.StringTokenizer;


// 백준 1149번. RGB 거리.
// DP문제 분류지만 케이스가 작아서 배열로 풀림.
public class BJ_1149 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][3];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = Integer.MAX_VALUE;
		for(int i=1; i<N; i++) {
			for(int j=0; j<3; j++) {
				int min = Integer.MAX_VALUE;
				
				for(int k=0; k<3; k++) {
					if(j == k) {
						continue;
					}
					if(arr[i-1][k] < min) {
						min = arr[i-1][k];
					}
				}
				
				arr[i][j] += min;
				if(i == N-1 && result > arr[i][j]) {
					result = arr[i][j];
				}
			}
		}
		
		System.out.println(result);
		br.close();
	}
}
