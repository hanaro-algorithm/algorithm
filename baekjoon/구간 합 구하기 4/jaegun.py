import sys
input = sys.stdin.readline

n, m = map(int, input().split())
numbers = list(map(int, input().split()))

# 이중 반복문으로 풀면 시간 복잡도를 넘기 때문에 누적합으로 풀어야 한다
prefix_sum = [0]
for i in range(n):
    prefix_sum.append(prefix_sum[i] + numbers[i])

for _ in range(m):
    start, end = map(int, input().split())
    print(prefix_sum[end] - prefix_sum[start - 1])