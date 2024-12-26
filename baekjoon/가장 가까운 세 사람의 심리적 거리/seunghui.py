from itertools import combinations

for _ in range(int(input())):
    N = int(input())
    if N > 32: 
        print(0)
        input()
        continue
    else:
        S = list(map(str, input().split()))
        Result = 10000000
        for c in combinations(S, 3):
            R = 0
            for i in range(4):
                if c[0][i] != c[1][i]:
                    R += 1
                if c[1][i] != c[2][i]:
                    R += 1
                if c[2][i] != c[0][i]:
                    R += 1
            Result = min(Result, R)
        print(Result)