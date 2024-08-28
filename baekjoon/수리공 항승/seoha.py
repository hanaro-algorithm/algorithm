N, L = map(int, input().split())
arr=list(map(int, input().split()))

arr.sort()
tapeCount=1
currIdx=0

for i in range(N):
    if L < (arr[i]-arr[currIdx]+1):
        tapeCount+=1
        currIdx=i
print(tapeCount)