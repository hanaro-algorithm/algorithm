import heapq
import sys

abs_heap = []
n = int(input())
for i in range(n):
    num = int(sys.stdin.readline())
    if num:
        heapq.heappush(abs_heap, (abs(num), num))
    else:
        if abs_heap:
            print(heapq.heappop(abs_heap)[1])
        else:
            print(0)

"""
시간초과

import sys

n= int(input())

plus=[]
minus=[]

for i in range(n):
    x=int(sys.stdin.readline().rstrip())
    if x!=0:
        if x>0:
            plus.append(x)
        else:
            minus.append(x)
    else:
        if len(minus)==0 and len(plus)==0:
            print(0)
        else:
            plus.sort(reverse=True)
            minus.sort()
            if len(minus)==0:
                print(plus.pop())
            elif len(plus)==0:
                print(minus.pop())
            else:
                if plus[-1]>=minus[-1]*(-1):
                    print(minus.pop())
                else:
                    print(plus.pop())
"""