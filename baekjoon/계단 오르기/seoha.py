import sys
input = sys.stdin.readline

N = int(input())
stairs = [int(input()) for _ in range(N)]

dp = [0] * N

if N < 2:
    print(stairs[N-1])
else:
    dp[0] = stairs[0]
    dp[1] = dp[0] + stairs[1]
    for i in range(2, N):
        dp[i] = max(dp[i-2], dp[i-3] + stairs[i-1]) + stairs[i]
    print(dp[-1])