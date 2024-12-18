import sys
from itertools import permutations
input = sys.stdin.readline

n = int(input())
k = int(input())
card = [int(input()) for _ in range(n)]

permus = permutations(card, k)
result = set()

for permu in permus:
    result.add(int(''.join(map(str, permu))))

print(len(result))

