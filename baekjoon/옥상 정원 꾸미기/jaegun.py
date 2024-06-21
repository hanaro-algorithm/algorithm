import sys

n = int(sys.stdin.readline())
buildings = [int(sys.stdin.readline()) for _ in range(n)]

stack = []
answer = 0

for i in range(n):
    while stack and stack[-1] <= buildings[i]:
        stack.pop()

    stack.append(buildings[i])
    answer += len(stack) -1

print(answer)