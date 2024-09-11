import sys
from collections import defaultdict
input = sys.stdin.readline

n, k = map(int, input().split())
numbers = list(map(int, input().split()))
number_count = defaultdict(int)

for number in numbers:
    number_count[number] += 0

end = 0
max_length = 0

for start in range(n):
    while end < n:
        if number_count[numbers[end]] >= k:
            break

        number_count[numbers[end]] += 1
        end += 1
        max_length = max(max_length, end - start)
    number_count[numbers[start]] -= 1

print(max_length)
