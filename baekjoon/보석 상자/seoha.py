import sys
input = sys.stdin.readline

N, M = map(int, input().split())
carrat = [int(input()) for _ in range(M)]

result = 0

#한 학생 가질 수 있는 최대 보석 개수
end = max(carrat)
start = 1

while start <= end:
    mid = (start + end) // 2
    temp = 0
    for c in carrat:
        if c % mid == 0:
            temp += c // mid
        else:
            temp += c // mid + 1
    if temp > N:
        start = mid + 1
    else:
        end = mid - 1
        result = mid
print(result)
