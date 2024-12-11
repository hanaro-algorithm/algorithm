import sys
input = sys.stdin.readline

H, W = map(int, input().split())
blocks = list(map(int, input().split()))
result = 0

for i in range(1, W-1):
    left = max(blocks[:i])
    right = max(blocks[i+1:])

    wall = min(left, right)

    if blocks[i] < wall:
        result += wall - blocks[i]

print(result)