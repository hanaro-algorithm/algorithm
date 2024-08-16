import sys
input = sys.stdin.readline

n,m = map(int,input().split())
data = list(map(int, input().split()))

prefixSum = [0]
for d in data:
    prefixSum.append(prefixSum[-1]+d)

for _ in range(m):
    i,j = map(int,input().split())
    print(prefixSum[j]-prefixSum[i-1])