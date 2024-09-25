import sys
input = sys.stdin.readline

n = int(input())
data = [input().strip() for _ in range(n)]

for i in range(len(data[0])):
    arr = set()
    for d in data:
        arr.add(d[-(i+1):])
    if len(arr) == n:
        print(i+1)
        break
