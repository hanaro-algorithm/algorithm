import sys
from collections import defaultdict

t=int(sys.stdin.readline())

for _ in range(t):
    string=sys.stdin.readline().rstrip()
    n=int(sys.stdin.readline())
    
    dic=defaultdict(list)

    for i in range(len(string)):
        if string.count(string[i])>=n:
            dic[string[i]].append(i)
 

    if not dic:
        print(-1)
    else:
        small=10000 
        big=1 
        
        for alpha in dic:
            for i in range(len(dic[alpha])-n+1):
                length=dic[alpha][i+n-1]-dic[alpha][i]+1
                small=min(small,length)
                big=max(big,length)

        print(small,big)