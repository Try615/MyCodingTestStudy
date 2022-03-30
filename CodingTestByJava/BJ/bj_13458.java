package day_220329;

import java.util.*;
import java.io.*;

public class bj_13458 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		long result = 0;
		
		for(int i=0; i<N; i++) {
			A[i] -= B;
			result += 1;
			
			if(A[i] > 0) {
				int sub = A[i] / C;
				result += sub;
				
				if(A[i] % C > 0) {
					result += 1;
				}
			}
		}
		
		System.out.println(result);
		br.close();
		
	}
}
