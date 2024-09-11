import sys
input = sys.stdin.readline

n = int(input())
data = list(map(int,input().split()))
s = int(input())

visited = [False] * n

def dfs(x):
    visited[x] = True

    if x - data[x] >= 0 and not visited[x - data[x]]:
        dfs(x - data[x])
    if x + data[x] < n and not visited[x + data[x]]:
        dfs(x + data[x])

dfs(s-1)
print(visited.count(True))