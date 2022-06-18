def dp_coin (ways,coins,N):
    for coin in coins:
        for i in range(N+1):
            if coin <= i:
                ways[i]=ways[i]+ways[i-coin]
        
    return ways[N]

T=int(input())
for test in range(T):
    N_coins=int(input())
    coins=[int(x) for x in input().split()]
    N=int(input())
    Ways=[0]*(N+1)
    Ways[0]=1
    print(dp_coin(Ways,coins,N))





    