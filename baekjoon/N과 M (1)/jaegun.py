import sys
from itertools import permutations
input = sys.stdin.readline

# 조합을 이용한 풀이
# n, m = map(int, input().split())
# p = permutations(range(1, n + 1), m)
# for i in p:
#     print(" ".join(map(str, i)))

# 백트래킹
def dfs():
    if len(answer) == m: # answer 리스트의 길이가 조건에 부합하면 출력
        print(' '.join(map(str, answer)))
        return

    for i in range(1, n + 1):
        if visited[i] == 0: # 방문 안했으면, answer list에 append하기
            visited[i] = 1
            answer.append(i)
            dfs()
            answer.pop() # 원상복구 과정
            visited[i] = 0

n, m = map(int, input().split())
answer = []
visited = [0] * (n+1)

dfs()