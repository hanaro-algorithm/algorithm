import sys
input = sys.stdin.readline

n = int(input())
data = list(map(int, input().split()))
q = int(input())

prefixSum = [0]

for i in range(n-1):
    if data[i] > data[i+1]:
        prefixSum.append(prefixSum[-1]+1)
    else:
        prefixSum.append(prefixSum[-1])
prefixSum.append(prefixSum[-1])

for _ in range(q):
    x,y = map(int,input().split())
    print(prefixSum[y-1]-prefixSum[x-1])