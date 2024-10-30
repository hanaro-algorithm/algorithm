import sys

input = sys.stdin.readline

n, m = map(int, input().split())
r, c, d = map(int, input().split())
data = [list(map(int, input().split())) for _ in range(n)]
result = 0

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]


def rotate_left(direction):
    return (direction + 3) % 4


def solution(x, y, direction):
    global result
    if data[x][y] == 0:
        data[x][y] = 2
        result += 1

    for _ in range(4):
        direction = rotate_left(direction)
        nx, ny = x + dx[direction], y + dy[direction]

        if data[nx][ny] == 0:
            solution(nx, ny, direction)
            return

    back_direction = (direction + 2) % 4
    bx, by = x + dx[back_direction], y + dy[back_direction]

    if data[bx][by] != 1:
        solution(bx, by, direction)

solution(r, c, d)
print(result)
