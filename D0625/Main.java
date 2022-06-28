package p2342;
import java.io.*;
import java.util.StringTokenizer;



public class Main {

    static int N;
    static int [][][] DP;
    static int [] Direction;
    static int Answer;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws NumberFormatException, IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Direction = new int [100000+1];
        Answer = INF;
        // 입력
        
        int now;
        st = new StringTokenizer(br.readLine(), " ");
        input : for(int i = 1; ;i++) {
            now = Integer.parseInt(st.nextToken());
            if(now == 0) {
                N = i - 1;
                break input;
            }
            Direction[i] = now;
        }
        DP = new int [N+1][5][5];
        
        //DP [i][j][k] = i번까지 발판을 밟았을때의 최소 비용 (왼발은 l에 오른발은 r에 위치)
        for(int i = 1 ; i <= N ; i++) {
            for(int l = 0 ; l <= 4 ; l++) {
                for(int r = 0 ; r <= 4 ; r++) {
                    DP[i][l][r] = INF;
                }   
            }
        }

        // 초기값
        // 첫번째 방향을 왼발로 밟느냐, 오른발로 밟느냐
        DP[1][0][Direction[1]] = 2;
        DP[1][Direction[1]][0] = 2;

        int next;
        for(int i = 1 ; i <= N - 1 ; i++) {
            for(int l = 0 ; l <= 4 ; l++) {
                for(int r = 0 ; r <= 4 ; r++) {
                    if(DP[i][l][r] != INF) { // 여기까지 밟는 방법이 있을 경우에만 계산한다.
                        next = Direction[i + 1];
                        if(r != next) { // 왼발로 밟기 (같은 위치에 두 발이 모두 있으면 안되기 때문에)
                            DP[i+1][next][r] = Math.min(DP[i+1][next][r], DP[i][l][r] + getCost(l, next));
                        }
                        if(l != next) { // 오른발로 밟기
                            DP[i+1][l][next] = Math.min(DP[i+1][l][next], DP[i][l][r] + getCost(r, next));
                        }
                    }
                }   
            }
        }

        for(int l = 0 ; l <= 4 ; l++) {
            for(int r = 0 ; r <= 4 ; r++) {
                Answer = Math.min(Answer, DP[N][l][r]);
            }   
        }

        bw.write(Answer+"");
        bw.flush();
        bw.close();
    }

    static int getCost (int from, int to){
        if(from == to) {
            return 1;
        } else if(from == 0) {
            return 2;
        } else if (Math.abs(from - to) == 2) {
            return 4;
        } else { 
            return 3;
        }
    }

}
