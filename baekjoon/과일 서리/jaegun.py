import sys
import math
input = sys.stdin.readline

N = int(input())
M = int(input())

def solution(N, M):
    answer = math.comb(M - 1, N - 1)

    return answer

print(solution(N, M))