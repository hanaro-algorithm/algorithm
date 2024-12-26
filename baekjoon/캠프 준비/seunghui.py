from itertools import combinations

N, L, R, X = map(int, input().split())
A = list(map(int, input().split()))
C = 0

for i in range(2, N+1):
    combi = list(combinations(A, i))
    for j in combi:
        if L<=sum(j)<= R and max(j)-min(j) >= X:
            C += 1
            
print(C)