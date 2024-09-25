import sys
input = sys.stdin.readline

n,m,b = map(int,input().split())
data = [list(map(int, input().split())) for _ in range(n)]
height = 0
second = sys.maxsize

for h in range(257):
    minus, plus = 0,0
    for i in range(n):
        for j in range(m):
            if data[i][j] > h:
                minus += data[i][j] - h
            elif data[i][j] < h:
                plus += h - data[i][j]

    if b + minus >= plus:
        if (minus * 2) + plus <= second:
            second = (minus * 2) + plus
            height = h

print(second, height)