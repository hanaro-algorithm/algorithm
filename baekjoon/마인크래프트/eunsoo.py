import sys
import itertools

input = sys.stdin.readline

n,m = map(int, input().split())
data = list(i+1 for i in range(n))

for i in itertools.permutations(data,m):
    for ii in i:
        print(ii, end=" ")
    print()