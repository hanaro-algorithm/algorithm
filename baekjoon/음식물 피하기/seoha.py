import sys

#재귀 횟수 제한 해제
sys.setrecursionlimit(100000)

#dfs 이용
def dfs(x, y):
    global size
    if x<=-1 or x>=N or y<=-1 or y>=M:
        return False
    if graph[x][y] == 1: #음식물이 있으면
        graph[x][y] = 0 #방문처리
        size += 1 #크기 1 증가
        dfs(x-1, y)
        dfs(x, y-1)
        dfs(x+1, y)
        dfs(x, y+1)
        return True
    return True


N, M, K = map(int, sys.stdin.readline().rstrip().split())
graph = [[0] * M for _ in range(N)] #음식물 위치

result=[]
size = 0

for i in range(K):
    x, y = map(int, sys.stdin.readline().rstrip().split())
    graph[x-1][y-1]=1

for i in range(N):
    for j in range(M):
        if dfs(i, j):
            result.append(size)
            size = 0

print(max(result))


"""
dfs 이용할 때 너무 많은 재귀가 이루어지면
런타임 에러 발생
(파이썬에서 재귀 횟수를 1000번으로 제한)
"""
