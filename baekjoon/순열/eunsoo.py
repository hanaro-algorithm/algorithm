import sys
input = sys.stdin.readline

def solution(arr,depth):
    if depth == len(arr):
        permutation.append(''.join(result))
        return

    for i in range(len(arr)):
        if not visited[i]:
            visited[i] = True
            result.append(arr[i])
            solution(arr, depth+1)
            result.pop()
            visited[i] = False

while True:
    per_input = input().rstrip()
    if not per_input:
        break
    data, n = per_input.split()

    visited = [False] * len(data)
    result = []
    permutation = []

    solution(data, 0)
    permutation.sort()

    if len(permutation) >= int(n):
        print(f"{data} {n} = {permutation[int(n)-1]}")
    else:
        print(f"{data} {n} = No permutation")
