import sys
input = sys.stdin.readline

n = int(input())
data = [[0,0]]
for _ in range(n):
    data.append(list(map(int,input().split())))

dp = [0 for _ in range(n+2)]
for i in range(n,-1,-1):
    if i+data[i][0] <= n+1:
        dp[i] = max(data[i][1] + dp[i+data[i][0]],dp[i+1])
    else:
        dp[i] = dp[i+1]

print(dp[0])