n = int(input())
people = list(map(int, input().split()))
people.sort(reverse=True)
answer = 0
cnt = 0
for i in people :
    cnt += 1
    if cnt >= i :
        answer += 1
        cnt = 0