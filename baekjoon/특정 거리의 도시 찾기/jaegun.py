from collections import deque

n, m, k, x = map(int, input().split())
graph = [[] for _ in range(n+1)]

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)

distance = [-1] * (n + 1)

def bfs(x, y): # x에서 시작, 거리
    answer = []
    queue = deque()
    queue.append(x)
    distance[x] = 0

    while queue:
        now_city = queue.popleft()

        # 현재 도시에서 이동할 수 있는 모든 도시를 확인
        for next_city in graph[now_city]:
            if distance[now_city] == -1:
                queue.append(next_city)
                # 최단 거리 갱신
                distance[next_city] = distance[now_city] + 1
                if distance[next_city] == y:
                    answer.append(next_city)

    if len(answer) == 0:
        print(-1)
    else:
        answer.sort()
        for i in answer:
            print(i, end='\n')

bfs(x, k)