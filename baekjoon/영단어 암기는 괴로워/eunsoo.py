import sys
input = sys.stdin.readline

n,m = map(int,input().split())
data = [input().strip() for _ in range(n)]

dic = dict()
for d in data:
    if len(d) >= m:
        if d  in dic:
            dic[d] += 1
        else:
            dic[d] = 1

for d in sorted(dic,key=lambda x:(-dic[x],-len(x),x)):
    print(d)