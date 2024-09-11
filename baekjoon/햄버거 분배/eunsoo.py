import sys
input = sys.stdin.readline

n,k = map(int, input().split())
data = list(map(str, input()))
cnt = 0

for hp in range(n):
    if data[hp] == 'P':
        for i in range(2*k+1):
            if -1 < hp+i-k < n and data[hp+i-k] == 'H':
                cnt += 1
                data[hp+i-k] = 'E'
                break

print(cnt)