import sys
from collections import deque

input = sys.stdin.readline

N, M, V = map(int, input().split())

visited = [False] * (N+1)
bfs_visited = [False] * (N+1)
graph = [[] for _ in range(N+1)]

for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(1, N+1):
    graph[i].sort()

def dfs(curr):
    visited[curr] = True
    print(curr, end=' ')

    for a in graph[curr]:
        if visited[a] == False:
            dfs(a)

def bfs(curr):
    q = deque([curr])
    bfs_visited[curr] = True
    while q:
        temp = q.popleft()
        print(temp, end=' ')

        for a in graph[temp]:
            if bfs_visited[a] == False:
                bfs_visited[a] = True
                q.append(a)

dfs(V)
print()
bfs(V)
