import sys

input = sys.stdin.readline

s = input().rstrip()
t = input().rstrip()

if s*50 in t*50 or t*50 in s*50:
    print(1)
else:
    print(0)