import sys
input = sys.stdin.readline

N = int(input())
works = []
result = 0

for _ in range(N):
    n = input().rstrip()
    if n=="0":
        if works:
            works[-1][1] -= 1
            if works[-1][1]==0: result += works.pop()[0]
    else:
        A, T = map(int, n.split()[1:])
        if T==1: result += A
        else: works.append([A, T-1])

print(result)