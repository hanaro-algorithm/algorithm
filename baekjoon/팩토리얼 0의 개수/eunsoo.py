import sys
input = sys.stdin.readline

def check(n):
    cnt = 0
    while n >= 5:
        n //= 5
        cnt += n
    return cnt

m = int(input().rstrip())
start = 0
end = 10 ** 8 * 5
result = -1

while start <= end:
    mid = (start+end)//2
    count = check(mid)
    if count > m:
        end = mid-1
    elif count < m:
        start = mid+1
    else:
        result = mid
        end = mid-1

print(result)