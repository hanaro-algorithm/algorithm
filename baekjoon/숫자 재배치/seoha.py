import sys

input = sys.stdin.readline

A, B = input().rstrip().split()

result = []
arr = []
visited = [False] * len(A)

def dfs():
    if len(A) == len(result):
        if result[0] != '0':
            if int(''.join(result)) < int(B):
                arr.append(int(''.join(result)))
        return
    for i in range(len(A)):
        if visited[i] == False:
            result.append(A[i])
            visited[i] = True
            dfs()
            visited[i] = False
            result.pop()
dfs()
if arr:
    print(max(arr))
else:
    print(-1)