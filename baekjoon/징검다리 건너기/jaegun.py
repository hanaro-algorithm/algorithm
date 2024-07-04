import sys
input = sys.stdin.readline

n = int(input())
rocks = list(map(int, input().split()))

INF = 1e9
dp = [INF for _ in range(n)]

dp = [0] + [INF] * (n - 1)
for i in range(1, n):
    for j in range(0, 1):
        power = max((i - j) * (1 + abs(rocks[i] - rocks[j])), dp[j])
        dp[i] = min(dp[i], power)

print(dp[n - 1])