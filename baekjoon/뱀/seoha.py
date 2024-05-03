from collections import deque

N=int(input()) # 보드 크기
graph=[[0]*N for _ in range(N)]

K=int(input()) # 사과 개수
for i in range(K):
    a, b = map(int, input().split())
    graph[a - 1][b - 1] = 2

L=int(input()) # 방향 변환 횟수
dirDict = dict()
queue = deque()
queue.append((0, 0))
for i in range(L):
    x, c = input().split()
    dirDict[int(x)] = c


dx=[0,1,0,-1]
dy=[1,0,-1,0]
x, y = 0, 0
graph[x][y] = 1
count = 0
direction = 0

def turn(alpha):
    global direction
    if alpha == 'L':
        direction = (direction - 1) % 4
    else:
        direction = (direction + 1) % 4

isEnd=False
while isEnd==False :
    count+=1
    x+=dx[direction]
    y+=dy[direction]
    if x < 0 or x >= N or y < 0 or y >= N:
        break

    if graph[x][y] == 2:
        graph[x][y] = 1
        queue.append((x, y))
        if count in dirDict:
            turn(dirDict[count])

    elif graph[x][y] == 0:
        graph[x][y] = 1
        queue.append((x, y))
        tx, ty = queue.popleft()
        graph[tx][ty] = 0
        if count in dirDict:
            turn(dirDict[count])

    else:
        isEnd = True
print(count)