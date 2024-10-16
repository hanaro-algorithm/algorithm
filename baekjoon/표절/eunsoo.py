import sys
input = sys.stdin.readline

n = int(input())
data = sorted(list(map(float, input().strip().split())))
cnt = 0

for i in range(n):
    start = i+1
    end = n-1
    while start <= end:
        mid = (start+end) // 2
        if data[i] >= 0.9 * data[mid]:
            start = mid + 1
        else:
            end = mid - 1
    cnt += start - i - 1

print(cnt)