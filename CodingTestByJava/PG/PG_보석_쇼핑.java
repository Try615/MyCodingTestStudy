package day_220701;

import java.util.*;

public class PG_보석_쇼핑 {
	public static void main(String[] args) {
		String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		
		int[] result = solution(gems);
		System.out.println(Arrays.toString(result));
	}
	
	public static int[] solution(String[] gems) {
		
		Set<String> set = new HashSet<>();
        for(String gem : gems){
            set.add(gem);
        }
        
        int numType = set.size();
        Map<String, Integer> map = new HashMap<>();
        
        int start = 0;
        int end = 0;
        
        int len = Integer.MAX_VALUE;
        int[] result = new int[] {0, 0};
        
        while(end < gems.length){
            if(map.get(gems[end]) == null){
                map.put(gems[end], 1);
            }else {
                map.put(gems[end], map.get(gems[end])+1);
            }
            end += 1;

            while(map.size() >= numType){
                int subLen = end - start;
                if(len > subLen){
                    result[0] = start+1;
                    result[1] = end;
                    len = subLen;
                }else if(len == subLen){
                    if(result[0] > start+1){
                        result[0] = start+1;
                        result[1] = end;
                    }
                }
                
                int used = map.get(gems[start]);
                if(used<=1){
                    map.remove(gems[start]);
                }else{
                    map.put(gems[start], used-1);
                }
                start += 1;
            }
        }    
        return result;
	}
}
