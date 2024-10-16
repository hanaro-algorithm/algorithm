import sys

input = sys.stdin.readline

R, C = map(int, input().split())
graph = []
result = [[False] * C for _ in range(R)]

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

x_start, x_end, y_start, y_end = R-1, 0, C-1, 0

for _ in range(R):
    temp = input().rstrip()
    graph.append([s for s in temp])

#네 방향 확인
for x in range(R):
    for y in range(C):
        if graph[x][y] == 'X':
            count = 0
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]

                if nx < 0 or nx >= R or ny < 0 or ny >= C or graph[nx][ny] == '.':
                    count += 1
            if count < 3:
                result[x][y] = True

#지도 범위 정하기
for i in range(R):
    if True in result[i]:
        x_start = min(x_start, i)
        x_end = max(x_end, i)
    for j in range(C):
        if result[i][j]:
            y_start = min(y_start, j)
            y_end = max(y_end, j)

#출력
for x in range(x_start, x_end + 1):
    for y in range(y_start, y_end + 1):
        if result[x][y]:
            print('X', end = '')
        else:
            print('.', end = '')
    print()

