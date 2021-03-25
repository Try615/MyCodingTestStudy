import java.io.*;
import java.util.*;


// SWEA 1263번. [S/W 문제해결 응용] 8일차 - 사람 네트워크2
// 인접 배열. 각 정점 별로 다익스트라 변형.
public class SWEA_1263 {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input_1263.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int testCase=1; testCase<=T; testCase++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int N = Integer.parseInt(st.nextToken());
			int[][] adjArr = new int[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					adjArr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int result = Integer.MAX_VALUE;
			
			boolean[] visited = new boolean[N];
			Deque<Integer> dq = new LinkedList<Integer>();
			for(int i=0; i<N; i++) {
				int start = i;
				int count = 0;
				
				Arrays.fill(visited, false);
				
				dq.offer(start);
				visited[start] = true;
				int visitNum = N-1;
				
				int layer = 1;
				
				boolean check = false;
				while(!dq.isEmpty()) {
					int size = dq.size();
					for(int j=0; j<size; j++) {
						int current = dq.poll();
						
						for(int k=0; k<N; k++) {
							if(!visited[k] && adjArr[current][k] == 1) {
								visited[k] = true;
								dq.offer(k);
								count += layer;
								visitNum--;
							}
							if(visitNum == 0) {
								check = true;
							}
						}
						if(check) {
							break;
						}
					}
					layer++;
					if(check) {
						break;
					}
				}
				dq.clear();
				result = Math.min(result, count);
			}
			
			sb.append("#").append(testCase).append(" ").append(result).append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}
}
