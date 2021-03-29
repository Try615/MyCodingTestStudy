import java.io.*;

// 백준 9252. LCS 2
// Longest Common Substring & Subsequence 문제. DP. 
public class BJ_9252 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String a = br.readLine();
		String b = br.readLine();
		
		int[][] dp = new int[a.length()+1][b.length()+1];
		
		for(int i=1; i<=a.length(); i++) {
			for(int j=1; j<=b.length(); j++) {
				if(a.charAt(i-1) == b.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1]+1;
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		int result = dp[a.length()][b.length()];
		int len = result;
		char[] subString = new char[len--];
		
		int r = a.length();
		int c = b.length();
		
		
		while(true) {
			if(len < 0) {
				break;
			}
			
			if(dp[r][c] == dp[r][c-1]) {
				c = c-1;
			}else if(dp[r][c] == dp[r-1][c]) {
				r = r-1;
			}else {
				subString[len--] = a.charAt(r-1);
				r = r-1;
				c = c-1;
			}
		}
		
		for(int i=0; i<result; i++) {
			sb.append(subString[i]);
		}
		System.out.println(result);
		System.out.println(sb.toString());
		br.close();
	}
}