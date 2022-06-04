import java.util.*;
class Solution {

    static int[] parent;
    static void union(int a, int b){
        parent[b] = a;
    }
    static int find(int a){
        if(parent[a]==a){
            return a;
        }
        return parent[a] = find(parent[a]);
    }
     public static int solution(int n, int[][] computers) {
        parent = new int[n];
        for(int i = 1; i < n; i++){
            parent[i] = i;
        }
        for(int i = 0; i < n; i++){
            for(int j =0; j < n; j++){
                if(i==j){
                    continue;
                }
                if(computers[i][j]==1){
                    int parentA = find(i);
                    int parentB = find(j);
                    if(parentA != parentB){
                        union(parentA, parentB);
                    }
                }
            }
        }
        Set<Integer> parentSet = new HashSet<>();
         
        for(int i =0; i < n; i++){
           parentSet.add(find(i));
        }
         
        
        return parentSet.size();
    }
}