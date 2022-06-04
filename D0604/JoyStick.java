// 알파벳은 총 26개, 두 알파벳 사이의 간격은  알파벳2 - 알파벳1 or 26 - (알파벳2 - 알파벳1)
// 위로 조작 : 해당하는 알파벳 - 'A'
// 아래로 조작 : 26 - 위로 조작한 횟수
// 1. A가 끝나는 지점을 endA변수에 구함. 그 지점까지 이동하는데 걸리는 값 왼, 오 비교
// 2. 더 짧은 방향을 move에 넣어줌. 가장 작은 move 마지막에 반환
//커서 위치가 바뀌게 되는 경우는 총 세 가지이다.
//1. 처음부터 쭉 오른쪽으로 가는 경우
//    가장 일반적인 경우로 name.length() - 1로 해당한다.
//2. 오른쪽으로 갔다 다시 리턴하여 왼쪽으로 가는 경우
//    ex) BBAAAAAYYY 의 경우, BB까지 갔다가 다시 돌아가 YYY를 완성해준다.
//3. 왼쪽으로 갔다 다시 리턴하여 오른쪽으로 가는 경우
//    ex) CCCAAAAAAY 의 경우, 처음부터 왼쪽으로 움직여 Y를 완성해주고 다시 오른쪽으로 돌아가 CCC를 완성해준다.
//https://born2bedeveloper.tistory.com/26
import java.util.Arrays;
class Solution {
    public int solution(String name) {
        int answer = 0;
        int move = name.length() - 1; // 오른쪽으로 쭉 간 횟수
        
        for(int i = 0; i < name.length(); i++) {
            answer += Math.min(name.charAt(i) - 'A', 26 - (name.charAt(i) - 'A')); //상,하 알파벳 맞추기
            if (i < name.length() - 1 && name.charAt(i + 1) == 'A') {
                int endA = i + 1;
                while(endA < name.length() && name.charAt(endA) == 'A')
                    endA++;
                move = Math.min(move, i * 2 + (name.length() - endA));// 오른쪽으로 갔다 다시 왼쪽으로 꺾기
                move = Math.min(move, i + (name.length() - endA) * 2);// 왼쪽으로 갔다 다시 오른쪽으로 꺾기
            }
        }
        return answer + move;
    }
}