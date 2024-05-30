import sys
sys.setrecursionlimit(10**6)

N=int(input())
arr=[]
for _ in range(N):
    arr.append(list(input()))

visited = [[False]*N for _ in range(N+1)]

def dfs(x, y, start):
    if x<= -1 or x>=N or y<=-1 or y>=N:
        return False
    if visited[x][y]==False and arr[x][y]==start:
        visited[x][y] = True
        dfs(x-1, y, start)
        dfs(x, y-1, start)
        dfs(x+1, y, start)
        dfs(x, y+1, start)
        return True
    return False

count=0
count2=0
for i in range(N):
    for j in range(N):
        num=arr[i][j]
        if dfs(i,j,num)==True:
            count+=1
for i in range(N):
    for j in range(N):
        if arr[i][j]=='R':
            arr[i][j]='G'
visited = [[False]*N for _ in range(N+1)]
for i in range(N):
    for j in range(N):
        num=arr[i][j]
        if dfs(i, j, num) == True:
            count2 += 1

print(count, count2)