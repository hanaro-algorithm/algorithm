# 0.5sec
from itertools import combinations_with_replacement
import math

n = int(input())
S = [i*i for i in range(1, int(math.sqrt(n))+1)]

if n in S:  
    print(1)
    exit()
for c in combinations_with_replacement(S,2): 
    if n==sum(c):
        print(2)
        exit()
for c in combinations_with_replacement(S,3):
    if n==sum(c):
        print(3)
        exit()
print(4) 
 
from math import sqrt
from itertools import combinations_with_replacement

# 0.1sec
# n = int(input())
# S1 = [i*i for i in range(1, int(sqrt(n))+1)]
# S2 = [sum(k) for k in combinations_with_replacement(S1, 2)]

# def answer(n):
#     if n in S1: 
#         return 1
#     elif n in S2: 
#         return 2
#     else:
#         for s in S1:
#             if n-s in S2: 
#                 return 3
#     return 4

# print(answer(n))