import sys

n = int(input())
data = sorted(list(map(int, sys.stdin.readline().split())))
x = int(input())

start = 0
end = len(data)-1
result = 0

while start < end:
    s = data[start] + data[end]
    if s < x:
        start += 1
    elif s > x :
        end -= 1
    else:
        result += 1
        start += 1
        end -= 1

print(result)
