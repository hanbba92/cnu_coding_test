import heapq

def dijkstra(start,distance, target, m):
    q=[]
    heapq.heappush(q,(0,start))
    distance[start]=0
    while q:
        dist,now = heapq.heappop(q)
        
        
        target.remove(now)
        if distance[now] < dist:
            continue
        
        if target:
            cost, destination = create_graph(now,target,m)

        cost = cost + dist 

        if cost < distance[destination]:
            distance[destination] = cost
            heapq.heappush(q, (cost, destination))
        #print(distance)

        

        

def create_graph(start, target, m):
   
    graph=[]
    
    for i in target:
        Bigger, Smaller=i,start
        if i < start : 
            Bigger, Smaller = Smaller, Bigger
        cost_from_Right=m-Bigger+Smaller
        cost_from_Left=Bigger-Smaller
        cost=min(cost_from_Right,cost_from_Left)
        #print("total_cost to", i, "=", cost)
        heapq.heappush(graph,(cost,i))
    
    (cost, destination) = heapq.heappop(graph)
    #print(f"possible target: {target}")
    #print(f"next cost and dest: {cost,destination}")
    return cost, destination


def solution(name):

    INF=int(1e9)

    m=len(name)

    start = 1

    distance = [INF]* (m+1)
    target=[1]
    joystick=0
    for ind, letter in enumerate(name):
        if letter !='A':
            target.append(ind+1)
        cost = ord(letter)-65
        if cost > 13: cost = 26-cost
        joystick+=cost 

    target=list(set(target))

    dijkstra(start,distance, target, m)


    last=0

    for dist in distance:
        if dist < INF:
            last=max(last,dist)

    answer = last + joystick
    return answer

print(solution("JERONE"))