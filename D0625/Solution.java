import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Solution {
	static int[] command;
	static int[][][] dp;
	static int N;
 	public static void main(String[] args) throws IOException{
 	// TODO Auto-generated method stub
 		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
 		StringTokenizer st = new StringTokenizer(br.readLine()," ");
 		N  = st.countTokens()-1;
 		command = new int[N+1];
 		for(int i =1; i<=N; i++) {
 			command[i] = Integer.parseInt(st.nextToken());
 		}
 		dp = new int[N+1][5][5];
       System.out.println(getMinScore(0, 0, 1));
 	}

 	 public static int getMinScore(int left, int right,int count) {
         if(count == N+1) return 0;
         if(dp[count][left][right] != 0) return dp[count][left][right];
         
         int leftScore = getMinScore(command[count], right, count+1) + getScore(left, command[count]);
         int rightScore = getMinScore(left, command[count], count+1) + getScore(right, command[count]);
         
         return dp[count][left][right] = Math.min(leftScore, rightScore);
     
     }
 	
 	static int getScore(int start, int end) {
 		if(start==0) return 2;
 		else if(start==end)return 1;
 		else if((Math.abs(start-end))==2) return 4;
 		else return 3;
 	}
}