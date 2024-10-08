import sys
from collections import deque

input = sys.stdin.readline

ips = list(input().strip().split(':'))
result = [] * 8

cnt = 0

for ip in ips:
    if ip != '':
        result.append(ip)
    else:
        if cnt == 0:
            for i in range(8 - len(ips) + 1):
                result.append('0000')
            cnt = 1
        elif cnt == 1:
            result.append('0000')

for i in range(8):
    if len(result[i]) != 4:
        temp = deque(result[i])
        for j in range(4-len(temp)):
            temp.appendleft('0')
        result[i] = ''.join(temp)

print(':'.join(result))
