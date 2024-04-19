N, M = map(int, input().split())
arr=[i+1 for i in range(N)]
seq=[]

for i in range(M):
    start, end = map(int, input().split())
    seq.append([start, end])

for s in seq:
    start=s[0]-1
    end=s[1]-1
    temp = []
    for j in range(N):
        if j==start:
            for k in range(end,start-1,-1):
                temp.append(arr[k])
        elif j>start and j<=end:
            continue
        else:
            temp.append(arr[j])
    arr=temp

for i in arr:
    print(i, end=' ')