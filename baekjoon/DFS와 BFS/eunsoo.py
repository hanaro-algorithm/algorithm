from collections import deque
import sys
input = sys.stdin.readline

N,M,V = map(int, input().split())
graph = [[False for _ in range(N+1)] for _ in range(N+1)]

for _ in range(M):
    a,b = map(int, input().split())
    graph[a][b] = True
    graph[b][a] = True

visited1 = [False for _ in range(N+1)]
visited2 = [False for _ in range(N+1)]

def dfs(n):
    visited1[n] = True
    print(n, end=" ")
    for i in range(1,N+1):
        if graph[n][i] and not visited1[i]:
            dfs(i)

def bfs(n):
    q = deque([n])
    visited2[n] = True
    while q:
        n = q.popleft()
        print(n, end=" ")
        for i in range(1, N + 1):
            if graph[n][i] and not visited2[i]:
                q.append(i)
                visited2[i] = True


dfs(V)
print()
bfs(V)
