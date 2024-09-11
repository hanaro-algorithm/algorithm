import sys

input = sys.stdin.readline

N = int(input())
prices = [list(map(int, input().split())) for _ in range(N)]

dx = [0, -1, 1, 0, 0]
dy = [0, 0, 0, -1, 1]

visited = [[0] * N for _ in range(N)]

result = 200 * 5 * 3
total = 0

# 꽃이 심어져 있는지 확인
def check(x, y):
    for i in range(5):
        nx = x + dx[i]
        ny = y + dy[i]
        if visited[nx][ny] == 1:
            return False
    return True


def flower(count):
    global total, result

    # 꽃을 3개 다 심었을 때 최소값 갱신
    if count == 3:
        result = min(result, total)
        return

    for i in range(1, N - 1):
        for j in range(1, N - 1):
            # 다섯 칸에 이미 심지 않았다면
            if check(i, j):
                for k in range(5):
                    x = i + dx[k]
                    y = j + dy[k]
                    visited[x][y] = 1
                    total += prices[x][y]
                flower(count + 1)

                # 다음 재귀를 위해 초기화
                for k in range(5):
                    x = i + dx[k]
                    y = j + dy[k]
                    visited[x][y] = 0
                    total -= prices[x][y]

flower(0)

print(result)
