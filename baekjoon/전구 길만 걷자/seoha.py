import sys
input = sys.stdin.readline

N = int(input())

bulbs = [input().rstrip() for _ in range(N)]
bulbs_count = []
bulbs_visited = [False] * N
result = 100 * N

for bulb in bulbs:
    temp = 0
    for i in range(1, len(bulb)):
        if bulb[i] != bulb[i-1]:
            temp += 1
    bulbs_count.append(temp)

def back(bulb_str, cnt, total):
    global result

    if cnt == N:
        result = min(result, total)
        return

    for i in range(N):
        if not bulbs_visited[i]:
            bulbs_visited[i] = True
            if bulb_str == bulbs[i][0]:
                back(bulbs[i][-1], cnt + 1, total + bulbs_count[i])
            else:
                back(bulbs[i][-1], cnt + 1, total + bulbs_count[i] + 1)
            bulbs_visited[i] = False

for i in range(N):
    bulbs_visited[i] = True
    back(bulbs[i][-1], 1, bulbs_count[i])
    bulbs_visited[i] = False

print(result)
