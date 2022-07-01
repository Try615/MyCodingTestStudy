package day_220701;

import java.util.*;

public class PG_가장_먼_노드 {
	public static void main(String[] args) {
		int n = 6;
		int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, 
				{1, 2}, {2, 4}, {5, 2}};
		
		int result = solution(n, vertex);
		System.out.println(result);
	}
	
	public static int solution(int n, int[][] edge) {
		List<Integer>[] arrList = new List[n+1];
        for(int i=1; i<=n; i++){
            arrList[i] = new ArrayList<>();
        }
        
        for(int[] e : edge){
            int start = e[0];
            int end = e[1];
            
            arrList[start].add(end);
            arrList[end].add(start);
        }
        
        int[] visited = new int[n+1];
        for(int i=0; i<n+1; i++){
            visited[i] = Integer.MAX_VALUE;
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {1, 0});
        visited[1] = 0;
        
        int maxCost = Integer.MIN_VALUE;
        
        while(!q.isEmpty()){
            int[] current = q.poll();
            
            int node = current[0];
            int cost = current[1];
            
            for(int next : arrList[node]){
                if(cost+1 >= visited[next]){
                    continue;
                }
                
                visited[next] = cost+1;
                q.offer(new int[] {next, cost+1});
                
                maxCost = Math.max(maxCost, cost+1);
            }
        }
        
        int result = 0;
        for(int i=1; i<n+1; i++){
            if(visited[i] == maxCost){
                result += 1;
            }
        }
        
        return result;
	}
}
