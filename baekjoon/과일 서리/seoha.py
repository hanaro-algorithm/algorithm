import sys

input = sys.stdin.readline

N = int(input())
M = int(input())

a = 1
b = 1
for i in range(1, M):
    a *= i
for i in range(1, N):
    b *= i
for i in range(1, M-N+1):
    b *= i

print(int(a/b))