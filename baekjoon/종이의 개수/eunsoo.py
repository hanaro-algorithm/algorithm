import sys
input = sys.stdin.readline

n = int(input())
data = [list(map(int,input().split())) for _ in range(n)]
result = [0]*3


def solution(x,y,n):
    paper = data[x][y]
    for i in range(x,x+n):
        for j in range(y,y+n):
            if paper != data[i][j]:
                next = n//3
                solution(x, y, next)
                solution(x+next, y, next)
                solution(x+(next*2), y, next)
                solution(x, y+next, next)
                solution(x+next, y+next, next)
                solution(x+(next*2), y+next, next)
                solution(x, y+(next*2), next)
                solution(x+next, y+(next*2), next)
                solution(x+(next*2), y+(next*2), next)
                return
    if paper == -1:
        result[0] += 1
    elif paper == 0:
        result[1] += 1
    elif paper == 1:
        result[2] += 1

solution(0,0,n)
print(result[0])
print(result[1])
print(result[2])