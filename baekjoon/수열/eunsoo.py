import sys
input = sys.stdin.readline

n,k = map(int, input().split())
data = list(map(int, input().split()))
temp = [0]
for i in range(n):
    temp.append(temp[i]+data[i])

start = 0
end = k
result = -sys.maxsize - 1
while end <= n:
    result = max(result, temp[end]-temp[start])
    start += 1
    end += 1
print(result)