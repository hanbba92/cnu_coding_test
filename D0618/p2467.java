package p2467;
import java.io.*;
import java.util.StringTokenizer;



public class Main {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(bReader.readLine());
		long[] arr = new long[n];
		StringTokenizer stringTokenizer = new StringTokenizer(bReader.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(stringTokenizer.nextToken());
		}
		int left = 0; int right = n-1;
		int ansLeft = 0, ansRight = 0;
		long min = Long.MAX_VALUE;
		while(left<right) {
			long newVal = arr[left] + arr[right]; 
			if(Math.abs(newVal) <= min) {
				ansLeft = left;
				ansRight = right;
				min = Math.abs(newVal);
			}
			// 새로운 값이 양수면 left를 줄인다. 반대면 right를 줄인다.
			if(newVal > 0) {
				right--;
			}else {
				left++;
			}
		}
		
		bWriter.write(arr[ansLeft] + " " + arr[ansRight]);
		bWriter.flush();
		bWriter.close();
	}
}
