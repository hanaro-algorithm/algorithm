K = int(input())
A = []

for _ in range(K):
    a = int(input())
    if a==0: A.pop()
    else: A.append(a)
        
print(sum(A))