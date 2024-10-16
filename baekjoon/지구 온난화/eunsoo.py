import sys
input = sys.stdin.readline

r,c = map(int, input().rstrip().split())
data = []
for i in range(r):
    data.append(list(input().rstrip()))
result = [['.' for _ in range(c)] for _ in range(r)]
dx = [0,0,-1,1]
dy = [1,-1,0,0]

for i in range(r):
    for j in range(c):
        if data[i][j] == 'X':
            cnt = 0
            for x in range(4):
                if 0 > i+dx[x] or i+dx[x] >= r or 0 > j+dy[x] or j+dy[x] >= c:
                    cnt+=1
                elif data[i+dx[x]][j+dy[x]] == '.':
                    cnt+=1
            if cnt < 3:
                result[i][j] = 'X'

lx=c
ly=c
rx=0
ry=0
for i in range(r):
    for j in range(c):
        if result[i][j] == 'X':
            lx = min(lx, i)
            ly = min(ly, j)
            rx = max(rx, i)
            ry = max(ry, j)

for i in range(lx,rx+1):
    for j in range(ly,ry+1):
        print(result[i][j], end="")
    print()