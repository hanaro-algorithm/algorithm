import sys

N, M = map(int, sys.stdin.readline().split())

arr1 = []
arr2 = []

for i in range(N):
    arr1.append(sys.stdin.readline().rstrip())
for i in range(M):
    arr2.append(sys.stdin.readline().rstrip())

result = list(set(arr1)&set(arr2))

result.sort()
print(len(result))
for i in result:
    print(i)


"""
시간 초과

import sys

N, M = map(int, input().split())

arr = []
result = []

for i in range(N):
    arr.append(sys.stdin.readline().rstrip())
for i in range(M):
    str = sys.stdin.readline().rstrip()
    if str in arr:
        result.append(str)

print(len(result))
for i in result:
    print(i)

"""
