import sys
from itertools import combinations_with_replacement

input = sys.stdin.readline

n = int(input())
data = [1,5,10,50]
array = set()

for i in combinations_with_replacement(data,n):
    array.add(sum(i))

print(len(array))