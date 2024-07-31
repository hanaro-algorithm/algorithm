import sys
input = sys.stdin.readline

n = int(input())
files = []

for _ in range(n):
    files.append(input().strip())

extension = []
answer = {}

for file in files:
    extension.append(file.split('.')[-1])

extension.sort()

for e in extension:
    if e in answer:
        answer[e] += 1
    else:
        answer[e] = 1

for key, value in answer.items():
    print(key, value)