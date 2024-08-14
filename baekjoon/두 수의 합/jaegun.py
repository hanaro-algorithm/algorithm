import sys
input = sys.stdin.readline

n = int(input())
numbers = list(map(int, input().split()))
x = int(input())

count = 0

numbers.sort()
start, end = 0, n-1

while start < end:
    sum = numbers[start] + numbers[end]
    if sum < x:
        start += 1
    elif sum > x:
        end -= 1
    else:
        count += 1
        start += 1
        end -= 1

print(count)