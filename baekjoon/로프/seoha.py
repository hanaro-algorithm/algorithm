import sys

N = int(sys.stdin.readline())
rope = []
result = []

for i in range(N):
    rope.append(int(sys.stdin.readline()))

rope.sort()
for i in range(N):
    result.append(len(rope)*rope[0])
    rope.pop(0)

print(max(result))