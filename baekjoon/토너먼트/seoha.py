import sys
input = sys.stdin.readline

N, kim, im = map(int, input().split())
result = 1

cnt = 1
temp = N
while temp > 1:
    temp //= 2
    cnt += 1

for i in range(cnt):
    kim = (kim + 1) // 2
    im = (im + 1) // 2
    if kim == im :
        break
    result += 1

print(result)