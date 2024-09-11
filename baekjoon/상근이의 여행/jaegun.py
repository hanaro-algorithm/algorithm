import sys
from collections import deque
input = sys.stdin.readline

t = int(input())

def bfs(start, count):
    queue = deque([start])
    visited[start] = True

    while queue:
        if visited.count(True) == n:
            return count

        v = queue.popleft()
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                count += 1
                visited[i] = True

for _ in range(t):
    n, m = map(int, input().split())
    visited = [False] * (n + 1)

    graph = [[] for _ in range(n + 1)]

    for i in range(m):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)

    answer = bfs(1, 0)
    print(answer)