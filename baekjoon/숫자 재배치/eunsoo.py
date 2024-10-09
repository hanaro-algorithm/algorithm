import sys

input = sys.stdin.readline

def solution(arr, depth):
    global answer
    if depth == len(arr):
        if int(''.join(result)) < int(b) and result[0] != '0':
            answer = max(answer, int(''.join(result)))
        return

    for i in range(len(arr)):
        if not visited[i]:
            result.append(arr[i])
            visited[i] = True
            solution(arr, depth+1)
            visited[i] = False
            result.pop()

a,b = input().rstrip().split()
sorted(list(a))
visited = [False] * len(a)
result = []
answer = -1
solution(a, 0)
print(answer)
