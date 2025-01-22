import sys
input = sys.stdin.readline

N, M, L = map(int, input().split())
S = [int(input()) for _ in range(M)]
S.append(L)

def check(mid):
    count = 0
    temp = 0
    for i in S:
        if (i - temp) >= mid:
            count += 1
            temp = i
    return count

for _ in range(N):
    Q = int(input())

    start = 1
    end = L
    result = 0

    while start <= end:
        mid = (start + end) // 2
        count = check(mid)

        if count > Q:
            start = mid + 1
            result = max(result, mid)
        else:
            end = mid - 1
    print(result)