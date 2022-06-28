import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Solution {
	static int[] arr;
	static int N;
	static int[] result;
 	public static void main(String[] args) throws IOException{
      // TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		st= new StringTokenizer(br.readLine()," ");

		arr =new int[N];
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		result = new int[2];
		int min = Integer.MAX_VALUE;

		int i=0;
		int j=N-1;
		while(i<j) {
			int temp=arr[i]+arr[j];
			min = Math.min(min,Math.abs(temp));
			if(min==Math.abs(temp)) {
				result[0]=Math.min(arr[i],arr[j]);
				result[1]=Math.max(arr[i],arr[j]);
				if(min==0) break;
			}
			if(temp<0) i++;
			else j--;
		}
		
		sb.append(result[0]+" "+result[1]).append('\n'); 
		System.out.print(sb);
	}
}
