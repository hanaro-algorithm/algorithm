import sys
input = sys.stdin.readline

from itertools import permutations

def solution(n, k, kits):
    answer = 0

    for perm in permutations(kits):
        weight = 500
        success = True

        for kit in perm:
            weight += kit - k
            if weight < 500:
                success = False
                break

        if success:
            answer += 1

    return answer

n, k = map(int, input().split())
kits = list(map(int, input().split()))

print(solution(n, k, kits))