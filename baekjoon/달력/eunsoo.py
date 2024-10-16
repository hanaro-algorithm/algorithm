import sys
input = sys.stdin.readline

n = int(input().rstrip())
cal = [0] * 366

for _ in range(n):
    s, e = map(int, input().rstrip().split())
    for i in range(s,e+1):
        cal[i] += 1

width = 0
height = 0
result = 0
for i in range(366):
    if cal[i] != 0:
        width += 1
        height = max(height, cal[i])
    else:
        result += width*height
        width = 0
        height = 0
result += width*height

print(result)