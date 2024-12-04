import sys

input = sys.stdin.readline

N = int(input())
result = 0
stack = []

# 현재 하고있는 과제의 점수와 시간
score, time = -1, -1

for _ in range(N):
    s = list(map(int, input().split()))

    if len(s) != 1:
        # 처음이 아니라면 -> 현재 하던 거 stack에 저장
        if score != -1:
            stack.append([score, time])
        score, time = s[1], s[2]

    # 과제 수행
    time -= 1

    # 과제 완료 시 점수 업데이트
    if time == 0:
        result += score
        if stack:
            score, time = stack.pop()
        else:
            score, time = 0, 0

print(result)