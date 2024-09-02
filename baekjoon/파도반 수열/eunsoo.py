import sys
input = sys.stdin.readline

dp = [1, 1, 1]
for i in range(98):
    dp.append(dp[i] + dp[i + 1])

for tc in range(int(input())):
    n = int(input())
    print(dp[n-1])