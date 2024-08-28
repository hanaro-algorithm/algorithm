from collections import deque
import sys

input = sys.stdin.readline

T = int(input().rstrip())

dx = [-2, -1, 1, 2, 2, 1, -1, -2]
dy = [1, 2, 2, 1, -1, -2, -2, -1]

#시작 지점 부터 각 칸까지의 모든 거리 구하기
def bfs(x, y):
    q = deque()
    q.append((x, y))

    while q:
        x, y = q.popleft()

        #이동하려는 칸일 경우
        if x == end[0] and y == end[1]:
            #이동한 횟수 리턴
            return graph[x][y]

        #모든 방향 탐색
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]

            #범위 내에 존재하고
            if 0 <= nx < l and 0 <= ny < l:
                #처음 방문한다면 탐색하기
                if graph[nx][ny] == 0:
                    q.append((nx, ny))
                    graph[nx][ny] = graph[x][y] + 1


for _ in range(T):
    l = int(input().rstrip())
    start = list(map(int, input().rstrip().split()))
    end = list(map(int, input().rstrip().split()))

    graph = [[0] * l for _ in range(l)]

    print(bfs(start[0], start[1]))