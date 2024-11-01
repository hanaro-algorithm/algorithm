import sys
input = sys.stdin.readline

N, K = map(int, input().split())
arr = [i for i in range(2, N+1)]

curr = 0
answer = 0

def check(target):
    for i in range(2, target):
        if target % i == 0:
            return False
    return True

P = 0

while curr <= K:
    #가장 작은 소수 찾기
    for a in arr:
        if check(a):
            P = a
            curr += 1
            break
    arr.remove(P)

    if curr == K:
        answer = P
        break

    #P의 배수 지우기
    arr2 = arr.copy()
    for a in arr2:
        if a % P == 0:
            curr += 1
            arr.remove(a)
            if curr == K:
                answer = a

print(answer)