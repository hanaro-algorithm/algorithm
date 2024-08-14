import sys
from itertools import combinations
input = sys.stdin.readline

n, m = map(int, input().split())
likes = [list(map(int, input().split())) for _ in range(n)]

chicken = 0
sum_max = []

for a, b, c in combinations(range(m), 3):
    total = 0
    for member in range(n):
        total += max(likes[member][a], likes[member][b], likes[member][c])
        sum_max.append(total)

print(max(sum_max))