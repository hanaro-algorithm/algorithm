import sys
from collections import deque
input = sys.stdin.readline

K = int(input())

for _ in range(K):
    V, E = map(int, input().split())
    color = [0 for _ in range(V+1)]
    graph = [[] for _ in range(V+1)]
    result = True

    for _ in range(E):
        u, v = map(int, input().split())
        graph[u].append(v)
        graph[v].append(u)

    def bfs(a):
        global result
        q = deque([a])
        color[a] = 1

        while q and result:
            curr = q.popleft()
            curr_color = color[curr]
            for b in graph[curr]:
                # 이분 그래프가 아닐때
                if color[b] == curr_color:
                    result = False
                    break

                # 연결된 노드 방문 안했다면 색 부여
                if color[b] == 0:
                    if curr_color == 1:
                        color[b] = 2
                    elif curr_color == 2:
                        color[b] = 1
                    q.append(b)

    for i in range(1, V+1):
        if color[i] == 0:
            bfs(i)

    if result:
        print('YES')
    else:
        print('NO')
