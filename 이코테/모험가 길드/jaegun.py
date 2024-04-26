from collections import deque

N = int(input())
members = list(map(int, input().split()))
members.sort()

count = 0
result = 0
group = []

for member in members:
    count += 1
    if count >= member:
        result += 1
        count = 0

print(result)