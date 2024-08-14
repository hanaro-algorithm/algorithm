import sys

read = sys.stdin.readline

N, K = map(int, read().rstrip().split())
arr = list(map(int, read().rstrip().split()))

count = [0] * (max(arr)+1)
result = 0

start, end = 0, 0

while end < N:
    if count[arr[end]] < K:
        count[arr[end]] += 1
        end += 1
    else:
        count[arr[start]] -= 1
        start += 1
    result = max(result, end - start)

print(result)