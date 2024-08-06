import sys

def dfs(graph, v, visited, cnt):
    visited[v] = True
    for i in graph[v]:
        if not visited[i]:
            cnt = dfs(graph, i, visited, cnt+1)
    return cnt

T = int(sys.stdin.readline().rstrip())
for _ in range(T):
    N, M = map(int, sys.stdin.readline().rstrip().split())
    graph = [[] for _ in range(N)]
    visited = [False] * N
    for i in range(M):
        a, b = map(int, sys.stdin.readline().rstrip().split())
        graph[a-1].append(b-1)
        graph[b-1].append(a-1)
    print(dfs(graph, 0, visited, 0))