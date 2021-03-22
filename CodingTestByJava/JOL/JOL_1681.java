import java.io.*;
import java.util.*;

// 정올 1681번. 해밀턴 순환회로.
// 시작점부터 전체를 돌아 시작점으로 돌아오는 TSP문제. dfs + 백트래킹.
public class JOL_1681 {
	static int N , result;
	static int[][] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		visited = new boolean[N];
		result = Integer.MAX_VALUE;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited[0] = true;
		dfs(0, 0, 1);
		
		System.out.println(result);
		br.close();
	}

	private static void dfs(int sum, int node, int cnt) {
		if(sum > result) {
			return;
		}
		
		if(cnt >= N) {
			boolean check = true;
			for(int i=0; i<N; i++) {
				if(!visited[i]) {
					check = false;
					break;
				}
			}
			
			if(check && arr[node][0] != 0) {
				result = Math.min(result, sum+arr[node][0]);
			}
			
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i] || arr[node][i] == 0) {
				continue;
			}
			
			visited[i] = true;
			dfs(sum + arr[node][i], i, cnt+1);
			visited[i] = false;
		}
	}
}
