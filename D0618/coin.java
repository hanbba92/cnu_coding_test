import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Solution {
	static int[] d;
	static int[] arr;
	static int N,M;
	public static void main(String[] args) throws IOException{
      // TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=Integer.parseInt(br.readLine());
	
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = Integer.parseInt(br.readLine());
			st= new StringTokenizer(br.readLine()," ");
	
			arr =new int[N+1];
			for(int i=1; i<=N; i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			
			M = Integer.parseInt(br.readLine());
			
	        d=new int[10001];//동전 1원부터 10000원까지 
	        d[0]=1;
	 
	        for (int i=1; i<=N; i++) {
	        	// arr[i]짜리 동전으로 M원 만드려면?
	            for (int j= arr[i]; j<=M; j++) {
	                d[j] += d[j- arr[i]];
	            }
	        }

			sb.append(d[M]).append('\n'); 
		}
		System.out.print(sb);
	}
}
