import sys
input = sys.stdin.readline

def solution(R, C, map):
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    new_map = [['.'] * C for _ in range(R)]

    for i in range(R):
        for j in range(C):
            if map[i][j] == 'X': # X인 경우만 체크
                sea_count = 0
                for k in range(4):
                    nx, ny = i + dx[k], j + dy[k]
                    if nx < 0 or nx >= R or ny < 0 or ny >= C or map[nx][ny] == '.':
                        sea_count += 1
                if sea_count < 3:
                    new_map[i][j] = 'X'

    # 지도 줄이기
    min_r, max_r, min_c, max_c = R, 0, C, 0
    for i in range(R):
        for j in range(C):
            if new_map[i][j] == 'X':
                min_r = min(min_r, i)
                max_r = max(max_r, i)
                min_c = min(min_c, j)
                max_c = max(max_c, j)

    # 출력
    for i in range(min_r, max_r + 1):
        print("".join(new_map[i][min_c:max_c + 1]))

R, C = map(int, input().split())
map = [list(input().rstrip()) for _ in range(R)]

solution(R, C, map)