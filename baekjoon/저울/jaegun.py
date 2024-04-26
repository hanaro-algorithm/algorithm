import sys
N = sys.stdin.readline()
nums = list(map(int, sys.stdin.readline().split()))
nums.sort()

first = 1
for num in nums:
    if first < num:
        break
    first += num


print(first)