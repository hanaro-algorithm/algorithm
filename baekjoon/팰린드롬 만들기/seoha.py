import sys

input = sys.stdin.readline

str = input().rstrip()
str_count = {}
result = ''
mid = ''
isFail = False

for s in str:
    if s in str_count:
        str_count[s]+=1
    else:
        str_count[s]=1

# 홀수는 1개, 이외 모두 짝수여야함
cnt = 0
for k, v in str_count.items():
    if v%2 != 0:
        cnt += 1
        if cnt == 1:
            mid = k
    if cnt > 1:
        result = "I'm Sorry Hansoo"
        isFail = True
        break

if isFail:
    print(result)
else:
    for k, v in sorted(str_count.items()):
        result += k * int(v/2)
    if len(mid) != 0:
        print(result+mid+result[::-1])
    else:
        print(result+result[::-1])