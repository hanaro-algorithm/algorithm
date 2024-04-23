from itertools import permutations
n = int(input())
lst = list(map(int, input().split(' ')))
lst.sort()

target = 1
for weight in lst:
    if target < weight:
        break

    target += weight

print(target)