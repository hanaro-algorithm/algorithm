import sys

input = sys.stdin.readline

N = int(input())
sizes = list(map(int, input().rstrip().split()))
sizes.sort()

result = 0

for i in range(N):
    start = i
    end = N

    while start < end:
        mid = (start + end) // 2
        if sizes[i] >= sizes[mid] * 0.9:
            start = mid + 1
        else:
            end = mid
    result += end - i - 1

print(result)