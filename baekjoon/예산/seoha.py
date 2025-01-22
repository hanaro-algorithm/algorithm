import sys
input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().split()))
M = int(input())

start = 0
end = max(arr)
result = 0

while start <= end:
    mid = (start + end) // 2

    # 상한액이 mid 가정; 모든 국가 예산 배정
    temp = 0
    for a in arr:
        if a <= mid:
            temp += a
        else:
            temp += mid
    # 예산 배정했을 때 국가예산보다 적다면
    if temp <= M:
        result = max(result, mid)
        start = mid + 1
    else:
        end = mid - 1

print(result)
