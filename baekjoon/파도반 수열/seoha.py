import sys

input = sys.stdin.readline


def memoization(n):
    if memo[n] == 0:
        memo[n] = memoization(n - 1) + memoization(n - 5)
    return memo[n]


T = int(input().rstrip())
memo = [0] * 101
memo[1] = 1
memo[2] = 1
memo[3] = 1
memo[4] = 2
memo[5] = 2

#memo = [1, 1, 1, 2, 2, 3, 4, 5, 7, 9] + ([0] * 91)

for _ in range(T):
    N = int(input().rstrip())
    print(memoization(N))



