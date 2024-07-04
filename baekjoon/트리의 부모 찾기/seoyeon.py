import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
vertices = [[0] for _ in range(N+1)]
parent = [0]*(N+1)

for _ in range(N-1):
    a, b = map(int, input().split())
    vertices[a].append(b)
    vertices[b].append(a)
    
parent[1] = 0
q = deque()
q.append(1)

while q:
    current = q.popleft()
    for v in vertices[current]:
        if parent[v] == 0:
            parent[v] = current
            q.append(v)

print('\n'.join(map(str, parent[2:])))