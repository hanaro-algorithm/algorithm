import sys

n = int(sys.stdin.readline().rstrip())
arr = list(map(int, sys.stdin.readline().rstrip().split()))
arr_set = set(arr)
x = int(sys.stdin.readline().rstrip())

result = 0

for i in arr:
    if x - i in arr_set:
        result+=1

print(result//2)

# in 이용할때 list를 set으로 바꿔주는 것이 시간 적게 걸림

"""
투포인터

import sys

n = int(sys.stdin.readline().rstrip())
arr = list(map(int, sys.stdin.readline().rstrip().split()))
x = int(sys.stdin.readline().rstrip())
result = 0

start, end = 0, n-1

arr.sort()
while start < end:
    sum = arr[start] + arr[end]
    if sum == x:
        result+=1
        start+=1
    elif sum < x:
        start+=1
    elif sum > x:
        end-=1

print(result)
"""