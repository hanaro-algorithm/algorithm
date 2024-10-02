import sys
from collections import deque

input = sys.stdin.readline

def bfs(start_x, start_y):
    queue = deque()
    queue.append([start_x, start_y])
    visited[start_x][start_y] = True

    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    while queue:
        x, y = queue.popleft()

        # 종료 조건 : 마지막 행에 도달한 경우
        if x == M - 1:
            return True

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < M and 0 <= ny < N and not visited[nx][ny] and board[nx][ny] == 0:
                queue.append([nx, ny])
                visited[nx][ny] = True

    return False

N, M = map(int, input().split())  # N은 열, M은 행
board = [list(map(int, input().strip())) for _ in range(M)]
visited = [[False] * N for _ in range(M)]

def solution():
    for y in range(N):
        if board[0][y] == 0 and not visited[0][y]:
            if bfs(0, y):
                print("YES")
                sys.exit(0)  # 경로를 찾으면 프로그램을 종료

    print("NO")

solution()