class Solution {
    static int answer=Integer.MAX_VALUE;
    static int[] weak;
    static int[] dist;
    public int solution(int n, int[] weak, int[] dist) {
        this.weak = new int[weak.length*2];
        this.dist=dist;

        for(int i=0; i<weak.length; i++){
            this.weak[i]=weak[i];
        }
         for(int i=weak.length; i<weak.length*2; i++){
            this.weak[i] = weak[i%weak.length] + n; //역방향을 다음에 // 뒤부터 촤륵
        }
        
        for(int i=0; i<weak.length; i++){
           getMinFriends(new boolean[dist.length],i,i+weak.length,0);//i~i+weak.length 만큼 한바퀴
        }
        
		return (answer == Integer.MAX_VALUE) ? -1:answer;
    }
    
    static void getMinFriends(boolean[] check,int start,int end,int sum){
        if(start==end){
            answer = Math.min(answer,sum);
            return;
        }
     
        for(int i=0; i<dist.length; i++){
            if(!check[i]){
                check[i]=true;

                int j=start+1;
                for(; j<end; j++){
                    if((weak[j]-weak[start])>dist[i]) break;
                }
                
                getMinFriends(check,j,end,sum+1);
                
                check[i]=false;
            }
        }
    }
}
