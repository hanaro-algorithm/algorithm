import sys
input = sys.stdin.readline

n = int(input())
schedule = [list(map(int, input().split())) for _ in range(n)]

# DP로 풀기
dp = [0] * (n + 1)

for i in range(n):
    if i + schedule[i][0] <= n: # 상담이 가능한 경우 (n을 넘지 않는 경우)
        dp[i + schedule[i][0]] = max(dp[i + schedule[i][0]], dp[i] + schedule[i][1])
    dp[i + 1] = max(dp[i + 1], dp[i])  # 다음 날로 넘어가는 경우도 갱신

print(max(dp))