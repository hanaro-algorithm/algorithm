import sys

N = int(sys.stdin.readline())
files = []
result = {}

for i in range(N):
    files.append(sys.stdin.readline().rstrip())

for file in files:
    s = file.split('.')[1]
    if s in result:
        result[s] += 1
    else:
        result[s] = 1

for name, n in sorted(result.items()):
    print(name, n)