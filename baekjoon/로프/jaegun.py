import sys
input = sys.stdin.readline

n = int(input())
answer = []

weight = []
for _ in range(n):
    weight.append(int(input()))

weight.sort()

for i in range(n):
    answer.append(weight[i]*(n-i))

print(max(answer))