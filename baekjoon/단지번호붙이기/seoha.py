N = int(input())
graph = []

for i in range(N):
    graph.append(list(map(int,input())))

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]
house = []

def dfs(x, y, count):
    if x < 0 or x >=N or y<0 or y>=N:
        return False
    if graph[x][y]==1:
        if graph[x][y] == 1:
            if len(house) != count + 1:
                house.append(1)
            else:
                house[count] += 1
        graph[x][y] = 0
        for i in range(4):
            dfs(x+dx[i], y+dy[i], count)
        return True
    return False

count = 0

for i in range(N):
    for j in range(N):
        if dfs(i,j,count) == True:
            count+=1

print(count)
house.sort()
for a in house:
    print(a)