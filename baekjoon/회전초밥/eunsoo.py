import sys
input = sys.stdin.readline

n,d,k,c = map(int, input().split())
data = [int(input().strip()) for _ in range(n)]
start = 0
end = k
result = 0

while start < n:
    s = set()
    if end < start:
        for i in range(start,n):
            s.add(data[i])
        for i in range(0,end):
            s.add(data[i])
    else:
        for i in range(start,end):
            s.add(data[i])
    s.add(c)
    if result < len(s):
        result = len(s)

    start += 1
    if end == n-1:
        end = 0
    else:
        end += 1

print(result)