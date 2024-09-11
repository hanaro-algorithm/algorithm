import sys
input = sys.stdin.readline

n = int(input())
data = [list(map(int,input().split())) for _ in range(n)]

def check(x,y,visited):
    for dx, dy in (0, 1), (1, 0), (0, -1), (-1, 0), (0,0):
        ax,ay = x+dx, y+dy
        if not (0 <= ax < n and 0 <= ay < n) or visited[ax][ay]:
            return False
    return True

def calc(x,y):
    cost = 0
    for dx, dy in (0, 1), (1, 0), (0, -1), (-1, 0), (0, 0):
        ax, ay = x + dx, y + dy
        cost += data[ax][ay]
    return cost

def solution(x,cnt,visited,cost_sum):
    global min_cost
    if cnt == 3:
        min_cost = min(min_cost,cost_sum)
        return

    for i in range(x,n-1):
        for j in range(1,n-1):
            if check(i,j,visited):
                for dx, dy in (0, 1), (1, 0), (0, -1), (-1, 0), (0, 0):
                    visited[i+dx][j+dy] = True
                solution(i,cnt+1, visited, cost_sum+calc(i,j))
                for dx, dy in (0, 1), (1, 0), (0, -1), (-1, 0), (0, 0):
                    visited[i+dx][j+dy] = False

min_cost = sys.maxsize
solution(1,0,[[False for _ in range(n)] for _ in range(n)],0)
print(min_cost)