import math
import sys
input = sys.stdin.readline

n = int(input())
m = int(input())

print(math.comb(m-1,n-1))