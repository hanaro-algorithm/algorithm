import sys

input = sys.stdin.readline
n,l = map(int, input().split())
data = sorted(list(map(int, input().split())))

cnt = 0
nn = 0

for i in data:
    if i > nn:
        cnt += 1
        nn = i + l -1

print(cnt)