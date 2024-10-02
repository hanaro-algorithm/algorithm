import sys
input = sys.stdin.readline

def dfs(x, y):
    if x == N - 1 and y == N - 1:
        print("HaruHaru")
        sys.exit(0)  # 프로그램 종료

    jump = board[x][y]

    if y + jump < N and not visited[x][y + jump]:  # 우측으로 이동할 수 있는지 확인
        visited[x][y + jump] = True
        dfs(x, y + jump)

    if x + jump < N and not visited[x + jump][y]:
        visited[x + jump][y] = True
        dfs(x + jump, y)


from collections import deque
def bfs(x, y):
    queue = deque()

    # 시작
    queue.append((x, y))
    visited[x][y] = True

    while queue:
        x, y = queue.popleft()

        if x == N - 1 and y == N - 1:
            print("HaruHaru")
            sys.exit(0)

        jump = board[x][y]

        # 우측으로 이동
        if y + jump < N and not visited[x][y + jump]:
            visited[x][y + jump] = True
            queue.append((x, y + jump))

        # 아래로 이동
        if x + jump < N and not visited[x + jump][y]:
            visited[x + jump][y] = True
            queue.append((x + jump, y))

N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]
visited = [[False] * N for _ in range(N)]

# 시작지점
bfs(0, 0)

print("Hing")