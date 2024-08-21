import sys
from itertools import combinations_with_replacement
input = sys.stdin.readline

n = int(input())
numbers = [1, 5, 10, 50]
answer = []

p = combinations_with_replacement(numbers, n)
for i in p:
    answer.append(sum(i))

print(len(set(answer)))