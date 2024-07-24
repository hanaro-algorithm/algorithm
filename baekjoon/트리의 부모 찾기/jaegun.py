import sys
sys.setrecursionlimit(10**8)

n = int(sys.stdin.readline())

graph = [[] for _ in range(n + 1)]
for _ in range(n - 1):  # There are n-1 edges
    x, y = map(int, sys.stdin.readline().split())
    graph[x].append(y)
    graph[y].append(x)

visited = [0] * (n + 1)

def dfs(v):
    for i in graph[v]:
        if not visited[i]:
            visited[i] = v
            dfs(i)

dfs(1)

for i in range(2, n + 1):
    print(visited[i])
