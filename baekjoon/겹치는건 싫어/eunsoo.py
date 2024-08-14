n,k = map(int, input().split())
data = list(map(int, input().split()))

start,end = 0,0
result = 0
arr = [0]*100001

while end < n:
    if arr[data[end]] == k:
        arr[data[start]] -= 1
        start += 1
    else:
        arr[data[end]] += 1
        end += 1
    result = max(result, end-start)

print(result)