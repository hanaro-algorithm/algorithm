import sys
from collections import deque, defaultdict

input = sys.stdin.readline

s, p = map(int, input().split())
letters = list(input().strip())
a, c, g, t = map(int, input().split())

required = {'A': a, 'C': c, 'G': g, 'T': t}
current = defaultdict(int)
answer = 0

for i in range(p):
    current[letters[i]] += 1

if all(current[key] >= required[key] for key in 'ACGT'):
    answer += 1

for i in range(p, s):
    current[letters[i - p]] -= 1
    current[letters[i]] += 1

    if all(current[key] >= required[key] for key in 'ACGT'):
        answer += 1

print(answer)