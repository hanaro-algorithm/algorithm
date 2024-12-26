import math

N, K, I = map(int, input().split())
T = 0

while K!=I:
    K -= K//2
    I -= I//2
    T += 1
print(T)