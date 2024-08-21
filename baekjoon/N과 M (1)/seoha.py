import sys

input = sys.stdin.readline
N, M = map(int, input().split())

def back(count, result):
    if count == M:
        print(*result)
        return

    for i in range(1, N+1):
        if i not in result:
            back(count+1, result + [i])

back(0, [])

"""
조합 이용 풀이

import sys
from itertools import permutations

input = sys.stdin.readline

N, M = map(int, input().rstrip().split())

arr = [i for i in range(1, N+1)]

results = permutations(arr, M)

for result in results:
    print(*result)
"""