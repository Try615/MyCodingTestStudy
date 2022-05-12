package day_220512;

import java.util.*;
import java.io.*;

public class BJ_1351 {
	static Map<Long, Long> map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		long N = Long.parseLong(st.nextToken());
		long P = Long.parseLong(st.nextToken());
		long Q = Long.parseLong(st.nextToken());
		
		map = new HashMap<Long, Long>();
		map.put(0l, 1l);
		
		long result = calc(N, P, Q);
		
		System.out.println(result);
		br.close();
	}
	
	public static long calc(long N, long P, long Q) {
		long ip = N/P;
		long iq = N/Q;
		
		if(map.get(N) == null) {
			map.put(N, calc(ip, P, Q) + calc(iq, P, Q));
		}
		return map.get(N);
	}
}
