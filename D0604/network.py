from collections import deque

def bfs(graph, start, visited, not_visited):
    queue = deque([start])

    visited[start] = True
    not_visited.remove(start)
    while queue:

        v = queue.popleft()

        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True
                not_visited.remove(i)
    return visited, not_visited

n,computers=3,[[1, 1, 0], [1, 1, 1], [0, 1, 1]]

graph=[[] for x in range(n)]

for i in range (n):
    for j in range(n):
        if computers[i][j] and i != j:
            graph[i].append(j)

network = 0
not_visited = [x for x in range(n)]
visited = [ False]* n


while not_visited:
    network+=1
    start = not_visited[0]
    visited, not_visited = bfs(graph,start,visited, not_visited)

print(network)