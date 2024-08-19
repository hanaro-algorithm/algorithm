import sys

input = sys.stdin.readline

N, M = map(int, input().split())
numbers = list(map(int, input().rstrip().split()))

prefix_sum = [0]
sum = 0
for number in numbers:
    sum += number
    prefix_sum.append(sum)

for _ in range(M):
    i, j = map(int, input().split())
    print(prefix_sum[j]-prefix_sum[i-1])
