N=input()
arr=list(map(int, input().split()))

arr.sort()
count=1

for a in arr:
    if count<a:
        break
    count+=a

print(count)

# 시간 초과 풀이
"""
from itertools import combinations

Find = True

while Find:
    if count in arr:
        count+=1
    else:
        countFind=False
        for index, a in enumerate(arr):
            if count<a:
                idx=index
                break
        temp=arr[:idx]
        for i in range(2,len(temp)+1):
            # 만들 수 있는 조합들
            permu = list(set(combinations(temp, i)))
            for j in permu:
                if count == sum(j):
                    count+=1
                    countFind=True
                    break
            if countFind == True:
                break
        if countFind != True:
            Find = False
"""