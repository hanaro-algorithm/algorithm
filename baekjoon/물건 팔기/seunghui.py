N = int(input())
M = []
R = []

for _ in range(N):
    m, d = map(int, input().split())
    M.append([m, d])
M.sort()
    
for i in range(N):
    r = 0
    for j in range(i, N):
        if M[i][0]-M[j][1] > 0:
            r += M[i][0]-M[j][1]
    R.append([r, M[i][0]])
R.sort(key = lambda x : (-x[0], x[1]))

print(R[0][1] if R[0][0]>0 else 0)