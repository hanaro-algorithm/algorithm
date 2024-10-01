import sys
input = sys.stdin.readline

n = int(input())
m = int(input())
dp = [[0 for _ in range(m+1)] for _ in range(n+1)]
for i in range(m):
    dp[1][i+1] = 1

for i in range(1,n+1):
    dp[i][i] = 1
    for j in range(i+1,m+1):
        dp[i][j] = dp[i-1][j-1] + dp[i][j-1]

print(dp[-1][-1])