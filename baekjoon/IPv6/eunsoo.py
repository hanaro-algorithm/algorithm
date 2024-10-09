import sys
input = sys.stdin.readline

ip = input().rstrip()
if ip[0] == ':':
    if len(ip) > 8:
        ip = '0' + ip[1:]
    else: ip = '0' + ip
elif ip[-1] == ':':
    if len(ip) > 8:
        ip = ip[:-1] + '0'
    else: ip = ip + '0'
ip = list(ip.split(":"))
result = []

if len(ip) > 8:
    if ip[len(ip)-1] == '0':
        ip.pop()

for i in ip:
    if i == '':
        for j in range(8-len(ip)):
            result.append('0000')
            continue
    ii = '0'* (4-len(i)) + i
    result.append(ii)
print(":".join(result))