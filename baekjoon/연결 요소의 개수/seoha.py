import sys
sys.setrecursionlimit(10**6)

input = sys.stdin.readline

N, M = map(int, input().split())
graph = [[] for _ in range(N+1)]
visited = [False for _ in range(N+1)]

result = 0

for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

def dfs(curr):
    for j in graph[curr]:
        if not visited[j]:
            visited[j] = True
            dfs(j)

for i in range(1, N+1):
    if not visited[i]:
        visited[i] = True
        dfs(i)
        result += 1

print(result)
