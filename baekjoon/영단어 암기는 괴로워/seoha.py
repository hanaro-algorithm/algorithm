import sys
from collections import defaultdict

input = sys.stdin.readline

N, M = map(int, input().split())

word = defaultdict(int)

for _ in range(N):
    a = input().rstrip()
    if len(a) >= M:
        word[a] += 1

result = sorted(word.items(), key = lambda x: (-x[1], -len(x[0]), x[0]))

for i in result:
    print(i[0])
