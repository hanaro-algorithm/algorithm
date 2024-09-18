import sys

input = sys.stdin.readline

N, K = map(int, input().split())
arr = list(map(int, input().rstrip().split()))

pre = []
pre.append(sum(arr[:K]))

for i in range(N-K):
    pre.append(pre[i] - arr[i] + arr[K+i])

print(max(pre))
