N = int(input())
M = int(input())
S = list(map(int, input().split()))

result = [] #[[후보자번호, 횟수], [],...]

for s in S:
    if s in [r[0] for r in result]:
        for r in result:
            if r[0] == s:
                r[1] += 1
                break
    else:
        if len(result) >= N:
            rm = min(result, key=lambda x: x[1])
            result.remove(rm)
        result.append([s, 1])

result.sort()
for r in result: print(r[0], end=' ')