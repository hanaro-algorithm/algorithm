import sys
input = sys.stdin.readline

n = int(input())
songs = list(map(int, input().split()))
q = int(input())

temp = [0] * n
prefix_sum = [0]
for i in range(n-1):
    if songs[i] > songs[i+1]:
        temp[i] += 1
    prefix_sum.append(prefix_sum[i] + temp[i])

for _ in range(q):
    start, end = map(int, input().split())
    print(prefix_sum[end-1] - prefix_sum[start-1])