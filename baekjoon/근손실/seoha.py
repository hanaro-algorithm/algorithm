import sys
from itertools import permutations

input = sys.stdin.readline

N, K = map(int, input().split())
A = list(map(int, input().split()))

permus = permutations(A, N)

result = 0

for permu in permus:
    weight = 500
    flag = True
    for i in permu:
        weight -= K
        weight += i
        if weight < 500:
            flag = False
            break
    if flag:
        result += 1

print(result)
