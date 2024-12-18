from itertools import permutations

n = int(input())
k = int(input())
C = []
R = set()

for _ in range(n):
    C.append(str(input()))
    
for c in permutations(C, k):
    r = ''.join(c)
    R.add(int(r))
    
print(len(R))