import sys
from collections import deque

input = sys.stdin.readline

n = int(input().rstrip())
Ai = list(map(int, input().rstrip().split()))
s = int(input().rstrip())

visited = [0] * n
cnt = 1

def bfs(x):
    global cnt

    q = deque()
    q.append(x)
    visited[x] = 1

    while q:
        x = q.popleft()
        for dx in [-Ai[x], Ai[x]]:
            nx = x + dx
            if 0 <= nx < n:
                if visited[nx] == 0:
                    q.append(nx)
                    visited[nx] = 1
                    cnt+=1
bfs(s-1)
print(cnt)