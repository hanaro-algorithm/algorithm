import sys
input = sys.stdin.readline

N = int(input())
tips = [int(input()) for _ in range(N)]
result = 0

tips.sort(reverse=True)

for i in range(N):
    if tips[i] - i > 0:
        result += tips[i] - i

print(result)