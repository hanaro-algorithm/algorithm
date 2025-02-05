import sys
input = sys.stdin.readline

arr = input().split('-')
result = sum(list(map(int, arr[0].split('+'))))

for i in range(1, len(arr)):
    temp = list(map(int, arr[i].split('+')))
    result -= sum(temp)

print(result)