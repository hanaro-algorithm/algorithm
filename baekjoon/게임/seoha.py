import sys

X, Y = map(int, sys.stdin.readline().rstrip().split())
Z = (Y*100)//X
result = 0

start = 0
end = X

if Z >= 99:
    result = -1
else:
    while start <= end:
        mid = (start + end)//2
        if ((Y+mid)*100)//(X+mid) > Z:
            result = mid
            end = mid - 1
        else:
            start = mid + 1

print(result)

"""
수학적 풀이

import sys

X, Y = map(int, sys.stdin.readline().rstrip().split())
Z = (Y*100)//X
result = 0

if Z >= 99:
    result = -1
else:
    n = ((Z+1)*X - 100*Y)/(100-(Z+1))
    if int(n) == n:
        result = n
    else:
        result = int(n) + 1
print(int(result))

"""