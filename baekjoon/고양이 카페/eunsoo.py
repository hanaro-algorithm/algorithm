n,k = map(int, input().split())
data = sorted(list(map(int, input().split())))

start = 0
end = len(data)-1
result = 0

while start < end:
    s = data[start]+data[end]
    if s > k:
        end -= 1
    else:
        result += 1
        start += 1
        end -= 1

print(result)
