import sys

input = sys.stdin.readline

n, m = map(int, input().split())
listen = set()
read = set()
answer = []

for i in range(0, n):
    listen.add(input().strip())

for j in range(0, m):
    read.add(input().strip())

answer = list(listen & read)

answer.sort()

print(len(answer))
for i in range(len(answer)):
    print(answer[i])