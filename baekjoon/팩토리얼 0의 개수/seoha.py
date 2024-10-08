import sys

input = sys.stdin.readline

M = int(input())

start = 0
end = (10**8) * 5
result = -1

def check(N):
    cnt = 0
    while N >= 5:
        N //= 5
        cnt += N
    return cnt

while start <= end:
    mid = (start + end) // 2
    cnt = check(mid)
    if cnt < M:
        start = mid + 1
    elif cnt == M:
        result = mid
        end = mid - 1
    else:
        end = mid - 1

print(result)
