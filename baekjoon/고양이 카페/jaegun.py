import sys
input = sys.stdin.readline

n, k = map(int, input().split())
cats = list(map(int, input().split()))

# 정답 변수
count = 0

# 정렬
cats.sort()

start, end = 0, n-1

while start < end:
    sum = cats[start] + cats[end]
    if sum > k:
        end -= 1
    else:
        start += 1
        end -= 1
        count += 1

print(count)