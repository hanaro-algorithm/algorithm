import sys
import math
input = sys.stdin.readline

x, y = map(int, input().split())
z = math.floor((y * 100) // x)

count = 0

if z >= 99:
    print(-1)
else:
    count = 0
    start = 1
    end = 1000000000
    while start <= end:
        mid = (start + end) // 2
        if ((y + mid)) * 100 // (x + mid) > z:
            count = mid
            end = mid - 1
        else:
            start = mid + 1
    print(count)

def binary_search(array, target, start, end):
    while start <= end:
        mid = (start + end) // 2
        if array[mid] == target:
            return mid
        elif array[mid] > target:
            end = mid - 1
        else:
            start = mid + 1
    return None
