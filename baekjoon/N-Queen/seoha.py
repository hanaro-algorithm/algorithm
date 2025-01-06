import sys
input = sys.stdin.readline

N = int(input())

visited = [0] * N
result = 0

def check(num):
    for i in range(num):
        if visited[num] == visited[i] or num - i == abs(visited[num] - visited[i]):
            return False
    return True

def dfs(curr):
    global result

    if curr == N:
        result += 1
    else:
        for i in range(N):
            visited[curr] = i
            if check(curr):
                dfs(curr + 1)

dfs(0)
print(result)