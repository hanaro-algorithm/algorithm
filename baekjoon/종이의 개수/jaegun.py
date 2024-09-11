import sys
input = sys.stdin.readline

# 분할정복 사용

# 정답 변수
count = {-1 : 0, 0 : 0, 1 : 0}

def check_paper(x, y, n):
    # 첫 번째 값을 기준으로 체크
    first_value = paper[x][y]
    for i in range(x, x + n):
        for j in range(y, y + n):
            # first_value랑 같지 않으면 9개로 분할
            if paper[i][j] != first_value:
                next_size = n // 3
                for dx in range(3):
                    for dy in range(3):
                        check_paper(x + dx * next_size, y + dy * next_size, next_size)
                return
    count[first_value] += 1


n = int(input())
paper = [list(map(int, input().split())) for _ in range(n)]

# 함수 호출
check_paper(0, 0, n)

print(count[-1])
print(count[0])
print(count[1])