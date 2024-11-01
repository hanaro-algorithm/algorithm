import sys
from collections import deque

input = sys.stdin.readline

n = int(input())
begin, target = map(int, input().split())
m = int(input())
visited = [False] * (n+1)

graph = [[] for _ in range(n+1)]
for _ in range(m):
    x, y = map(int, input().split())
    temp = graph[x]
    temp.append(y)
    graph[x] = temp
    temp = graph[y]
    temp.append(x)
    graph[y] = temp

q = deque([[begin, 0]])

result = -1

while q:
    start, temp = q.popleft()

    if start == target:
        result = temp
        break

    for i in graph[start]:
        if visited[i] == False:
            q.append([i, temp + 1])
            visited[i] = True

print(result)