import sys
input = sys.stdin.readline

n = int(input())
a = list(map(int, input().split()))
s = int(input())

count = 1
visited = [0] * n

def dfs(x):
    global count
    for nx in (x+a[x], x-a[x]):
        if 0 <= nx <n and visited[nx] == 0:
            count+=1;
            visited[nx]=1
            dfs(nx)
dfs(s-1)
print(count)