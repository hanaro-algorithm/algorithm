from collections import deque

def dfs(graph, v, visited):
    # 현재 노드를 방문 처리
    visited[v] = True
    print(v, end=' ')
    # 현재 노드와 연결된 다른 노드를 재귀적으로 방문
    for i in sorted(graph[v]):
        if not visited[i]:
            dfs(graph, i, visited)

def bfs(graph, start, visited):
    # 큐(queue) 구현을 위해 deque 라이브러리 사용
    queue = deque([start])
    # 현재 노드를 방문처리
    visited[start] = True

    # 큐가 빌 때까지 반복
    while queue:
        # 큐에서 하나의 원소를 뽑아 출력
        v = queue.popleft()
        print(v, end=' ')
        # 해당 원소(노드)와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
        for i in sorted(graph[v]):
            if not visited[i]:
                queue.append(i)
                visited[i] = True

# 입력
N, M, V = map(int, input().split())

# 그래프 초기화 (인접 리스트)
graph = [[] for _ in range(N + 1)]

# 간선 정보 입력
for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

# 방문 기록 초기화
visited1 = [False] * (N + 1)
visited2 = [False] * (N + 1)

# DFS 및 BFS 수행
dfs(graph, V, visited1)
print()
bfs(graph, V, visited2)
