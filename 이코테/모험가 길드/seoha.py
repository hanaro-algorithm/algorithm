N = int(input())
arr = list(map(int, input().split()))

count = 0
while arr:
    for i in range(max(arr)):
        arr.remove(max(arr))
    count+=1

print(count)