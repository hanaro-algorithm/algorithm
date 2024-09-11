import sys

input = sys.stdin.readline

N = int(input().rstrip())
paper = [list(map(int, input().rstrip().split())) for _ in range(N)]
result = [0, 0, 0]

def div(r, c, n):
    global paper

    num = paper[r][c]
    # 1개 종이 숫자 확인
    for i in range(r, r+n):
        for j in range(c, c+n):
            # 1개 종이에서 모두 같은 숫자가 아닐 때 -> 분할
            if paper[i][j] != num:
                for k in range(3):
                    for l in range(3):
                        div(r + k * (n//3), c + l * (n//3), n//3)
                return
    if num == -1:
        result[0] += 1
    elif num == 0:
        result[1] += 1
    else:
        result[2] += 1


div(0, 0, N)
for r in result:
    print(r)