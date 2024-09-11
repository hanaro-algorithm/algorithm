import sys

input = sys.stdin.readline

N = int(input().rstrip())
info = [list(map(int, input().rstrip().split())) for _ in range(N)]
dp = [0] * (N + 1) #메모이제이션
result = 0

for i in range(N-1, -1, -1):
    # 뒤에서 부터 가능한 상담인지 확인
    time = info[i][0] + i
    if time <= N:
        dp[i] = max(info[i][1] + dp[time], result)
        result = dp[i]
    else:
        dp[i] = result

print(result)