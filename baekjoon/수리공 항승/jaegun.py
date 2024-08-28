import sys
input = sys.stdin.readline

n, l = map(int, input().split())
pipes = list(map(int, input().split()))

# 오름차순 정렬
pipes.sort()

# 정답 변수
count = 1

start = pipes[0]
end = start + l

for i in range(n):
    if pipes[i] in range(start, end):
        continue
    else:
        count += 1
        start = pipes[i]
        end = start + l

print(count)