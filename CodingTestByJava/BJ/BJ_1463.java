import java.io.*;

// 백준 1463. 1로 만들기.
// DP 문제.
public class BJ_1463 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1];
		for(int i=0; i<N; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		
		for(int i=N; i>0; i--) {
			if(i%2 == 0) {
				dp[i/2] = Math.min(dp[i/2], dp[i] + 1);
			}
			if(i%3 == 0) {
				dp[i/3] = Math.min(dp[i/3], dp[i] + 1);
			}
			dp[i-1] = Math.min(dp[i-1], dp[i] + 1);
		}
		
		System.out.println(dp[1]);
		br.close();
	}
}
