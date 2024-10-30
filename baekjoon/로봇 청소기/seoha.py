import sys

input = sys.stdin.readline

# 0: 북, 1: 동, 2: 남, 3: 서

N, M = map(int, input().split())
r, c, d = map(int, input().split())
room = [list(map(int, input().split())) for _ in range(N)]
result = 0

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

while True:
    if room[r][c] == 0:
        room[r][c] = 2
        result += 1

    isClean = True
    for i in range(4):
        nx = r + dx[i]
        ny = c + dy[i]

        if 0 < nx < N and 0 < ny < M and room[nx][ny] == 0:
            isClean = False

    if isClean:
        #후진
        nr = r + dx[(d + 2) % 4]
        nc = c + dy[(d + 2) % 4]

        if nr < 0 or nr >= N or nc < 0 or nc >= M:
            break
        elif 0 < nr < N and 0 < nc < M and room[nr][nc] == 1:
            break
        else:
            r = nr
            c = nc
    else:
        #왼쪽 돌기
        for _ in range(4):
            d = (d + 3) % 4
            nr = r + dx[d]
            nc = c + dy[d]

            if 0 < nr < N and 0 < nc < M and room[nr][nc] == 0:
                r = nr
                c = nc
                break

print(result)

