import sys
input = sys.stdin.readline

from collections import deque

def solution(n, people, m, relationship):

    graph = [[] for _ in range(n + 1)]  # 그래프 초기화
    for x, y in relationship:
        graph[x].append(y)
        graph[y].append(x)

    visited = [-1] * (n+1)

    def bfs(start, target, graph, visited):

        # 초깃값
        queue = deque([start])
        visited[start] = 0

        while queue:
            current = queue.popleft()

            if current == target:
                return visited[current]

            for i in graph[current]:
                if visited[i] == -1:
                    visited[i] = visited[current] + 1
                    queue.append(i)

        return -1

    answer = bfs(people[0], people[1], graph, visited)

    return answer


n = int(input())
people = list(map(int, input().split()))
m = int(input())
relationship = [list(map(int, input().split())) for _ in range(m)]

print(solution(n, people, m, relationship))