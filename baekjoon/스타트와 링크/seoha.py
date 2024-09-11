import sys
from itertools import combinations
from collections import deque

input = sys.stdin.readline

N = int(input().rstrip())
S = [list(map(int, input().rstrip().split())) for _ in range(N)]
result = 100

people = [i for i in range(N)]

d = deque(list(combinations(people, N//2)))

while d:
    starts = d.popleft()
    links = d.pop()

    starts_point = 0
    links_point = 0

    for start in starts:
        sum = 0
        for start_team in starts:
            sum += S[start][start_team]
        starts_point += sum

    for link in links:
        sum = 0
        for link_team in links:
            sum += S[link][link_team]
        links_point += sum

    if abs(starts_point-links_point) < result:
        result = abs(starts_point-links_point)

print(result)

