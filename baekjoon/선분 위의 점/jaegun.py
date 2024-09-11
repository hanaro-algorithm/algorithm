import sys

n, m = map(int, sys.stdin.readline().split())

dots = list(map(int, sys.stdin.readline().split()))
lines = []
for _ in range(m):
    lines.append(list(map(int, sys.stdin.readline().split())))

def binary_search(array, target, find_first):
    start, end = 0, len(array) - 1
    result = len(array)
    while start <= end:
        mid = (start + end) // 2
        if array[mid] > target or (find_first and array[mid] >= target):
            result = mid
            end = mid - 1
        else:
            start = mid + 1
    return result

dots.sort()

for line in lines:
    start, end = line
    left_index = binary_search(dots, start, True)
    right_index = binary_search(dots, end, False)
    print(right_index - left_index)