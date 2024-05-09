import sys
from collections import deque

input = sys.stdin.readline
N, M, K, X = map(int, input().split())

graph = [[] for _ in range(N+1)]
Que = deque()
visited = set()

distances = [0]*(N+1)

for i in range(M):
    x, y = map(int, input().split())
    graph[x].append(y)
Que.append(X)
visited.add(X)

while Que:
    node = Que.popleft()
    for next in graph[node]:
        if next not in visited:
            Que.append(next)
            visited.add(next)
            distances[next] = distances[node]+1

if K in distances:
    for destination in range(1,N+1):
        if distances[destination] ==K:
            print(destination)
else:
    print(-1)