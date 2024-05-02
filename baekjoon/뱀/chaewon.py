# N x N
N = int(input())
myMap = [[0 for _ in range(N)] for _ in range(N)]
# 방향 전환
# L <-    -> D
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
direction = 0

apple = int(input())
for _ in range(apple):
    y, x = map(int, input().split(' '))
    myMap[y][x] = 1

L = int(input())
time_side = []
for _ in range(L):
    time, side = input().split(' ')
    time_side.append([int(time), side])

s_x, s_y = 0, 0
time, side = time_side.pop(0)
time -= 1
count = 0
height = 1
while True:
    if time == 0 and side != '': # 방향 전환
        if side == "D":
            if direction == 3: direction = 0
            else: direction = (direction + 1)
        else:
            if direction == 0: direction = 3
            else: direction = (direction - 1)

    if time == 0 and time_side:
        time, side = time_side.pop(0)
        continue

    new_x = s_x+dx[direction]
    new_y = s_y+dy[direction]
    if new_x == -1 or new_x == N or new_y == -1 or new_y == N:
        break

    print('====',myMap[new_y][new_x])
    if myMap[s_y+dy[direction]][s_x+dx[direction]] == 1: # 사과가 있는 경우
        print('=============')
        height += 1
        s_x = s_x + dx[direction] * height
        s_y = s_y + dy[direction] * height
        count += 1
    else: # 사과가 없는 경우
        s_x = s_x + dx[direction] * height
        s_y = s_y + dy[direction] * height
        count += 1

    time -= 1
    print(s_y,s_x, time)
print(count)