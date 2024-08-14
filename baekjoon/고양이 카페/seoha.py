import sys

N, K = map(int, sys.stdin.readline().rstrip().split())
w = list(map(int, sys.stdin.readline().rstrip().split()))

max = 0

start, end = 0, N-1

w.sort()
while start < end:
    sum = w[start] + w[end]
    if sum <= K:
        max += 1
        start +=1
        end -= 1
    elif sum > K:
        end -= 1

print(max)