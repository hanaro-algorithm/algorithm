import sys

sys.setrecursionlimit(10000)
n, l, r = map(int,input().split())
popul = []

for _ in range(n):
    popul.append(list(map(int,input().split())))
    
dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

def dfs(a, b, graph):
    visitied[a][b]=True
    for i in range(4):
        nx = a + dx[i]
        ny = b + dy[i]
        if (0<=nx<n) and (0<=ny<n):
            if (not visitied[nx][ny]) and (l <= (abs(graph[nx][ny] - graph[a][b])) <= r):
                loca.append((nx,ny))
                dfs(nx,ny,graph)
    return loca

count = 0

while True:
    visitied = [[False] * n for _ in range(n)]
    flag = False 
    
    for i in range(n):
        for j in range(n):
            loca = [(i,j)]
            if not visitied[i][j]:
                loca = dfs(i,j,popul)            
            if len(loca)>1:
                flag = True
                sum = 0
                for x,y in loca:
                    sum += popul[x][y]
                avg = sum // len(loca)
                for a,b in loca:
                    popul[a][b] = int(avg)

    if not flag:
        print(count)
        break
    
    count += 1