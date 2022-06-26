package p9084;
import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] dp;
		int t, n, num, tar, ans;
		t = Integer.parseInt(bReader.readLine());
		StringTokenizer st;
		while((t--)!=0) {
			n = Integer.parseInt(bReader.readLine());
			st = new StringTokenizer(bReader.readLine());
			tar = Integer.parseInt(bReader.readLine());
			dp = new int[tar+1];
			dp[0] = 1;
			ans = 0;
			while((n--)!=0) {
				num = Integer.parseInt(st.nextToken());
				for(int i = num; i <= tar; i++) {
					dp[i]+= dp[i-num];
				}
			}
			ans = dp[tar];
			bWriter.write(ans+"\n");
		}
		bWriter.flush();
		bWriter.close();
	}
}
