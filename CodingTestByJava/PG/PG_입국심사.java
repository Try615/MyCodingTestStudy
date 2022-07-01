package day_220701;

import java.util.Arrays;

public class PG_입국심사 {
	public static void main(String[] args) {
		int n = 6;
		int[] times = {7, 10};
		
		long result = solution(n, times);
		System.out.println(result);
	}
	
	public static long solution(int n, int[] times) {
		Arrays.sort(times);
		
		long start = times[0];
		long end = (long)n * times[times.length-1];
		long result = Long.MAX_VALUE;
		
		while(start <= end) {
			long mid = (start+end)/2l;
			long processPeople = 0l;
			
			for(int time : times) {
				processPeople += mid / (long)time;
			}
			
			if(processPeople < n) {
				start = mid+1;
			}else if(processPeople >= n) {
				end = mid-1;
				result = Math.min(result, mid);
			}
		}
		
		return result;
	}
}
