package com.ssafy.algo0317;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_14889 {
	static int N;
	static int numCase;
	static int result = Integer.MAX_VALUE;
	static int[][] power;
	static long[] f;
	static long factorial(int i) {
		if(i==0)
			return f[0] = 1;
		return f[i] = i * factorial(i-1);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		
		f = new long[N+1];
		factorial(N);
		
		power = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				power[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		numCase = (int)(f[N] / (f[N/2] * f[N-(N/2)]))/2;
		makeCombination(N, new int[N/2], 0, 0);
		
		System.out.println(result);
		br.close();
	}

	private static void makeCombination(int arr, int[] selected, int toSelect, int idx) {
		if(numCase <= 0)
            return;
         
        if(toSelect >= selected.length) {
            int[] teamA = selected.clone();
            int[] teamB = new int[teamA.length];
            int checked = 0;
            int index = 0;
             
            int powerA = 0;
            int powerB = 0;
             
            for(int a=0; a<teamA.length; a++) {
                checked |= 1<<teamA[a];
            }
            for(int a=0; a<arr; a++) {
                if((checked & (1<<a)) == 0) {
                    teamB[index++] = a; 
                }
            }
             
            for(int a=0; a<teamA.length; a++) {
                for(int b=a+1; b<teamA.length; b++) {
                    powerA += power[teamA[a]][teamA[b]] + power[teamA[b]][teamA[a]];
                    powerB += power[teamB[a]][teamB[b]] + power[teamB[b]][teamB[a]];
                }
            }
             
            result = Math.min(result, Math.abs(powerA - powerB));
            numCase--;
            return;
        }
		
		for(int i=idx; i<arr; i++) {
			selected[toSelect] = i;
			makeCombination(arr, selected, toSelect+1, i+1);
		}
		
	}
}
