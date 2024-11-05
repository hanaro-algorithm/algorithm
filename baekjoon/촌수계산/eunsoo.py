import sys
input = sys.stdin.readline

n = int(input().rstrip())
a,b = map(int, input().split())
m = int(input().rstrip())
graph = [[False for _ in range(n+1)] for _ in range(n+1)]
for _ in range(m):
    x,y = map(int, input().split())
    graph[x][y] = True
    graph[y][x] = True
visited = [False for _ in range(n+1)]
result = -1

def dfs(v, depth):
    global result
    visited[v] = True

    if v == b:
        result = depth
        return

    for i in range(1,n+1):
        if not visited[i] and graph[v][i]:
            dfs(i, depth+1)
            visited[i] = False

dfs(a, 0)
print(result)