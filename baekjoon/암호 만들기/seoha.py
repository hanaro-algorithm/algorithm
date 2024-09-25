import sys
from itertools import combinations

input = sys.stdin.readline


L, C = map(int, input().split())
arr = list(input().rstrip().split())

vowel = set(['a', 'e', 'i', 'o', 'u'])

passwords = list(combinations(arr, L))
results = []

for password in passwords:
    if len(set(password) & vowel) == 0:
        continue
    if len(set(password) - vowel) < 2:
        continue

    password_list = list(password)
    password_list.sort()
    results.append(''.join(password_list))

results.sort()
for result in results:
    print(result)
