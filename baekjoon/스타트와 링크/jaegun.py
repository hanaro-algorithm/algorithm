import sys
input = sys.stdin.readline

n = int(input())
s = [list(map(int, input().split())) for _ in range(n)]

# 백트래킹으로 풀기
# 백트래킹을 활용해서 만들 수 있는 조합의 경우의 수 만들기
# N자리의 모든 갯수를 탐색할 필요 없이 필요한 부분(절반)만 탐색 가능

res = float('inf')
visited = [0] * n

# 차이 구하는 함수
def make_team():
    # start, link 초기 변수 설정
    start, link = 0, 0
    for i in range(n):
        for j in range(n):
            # visited가 1인 사람들끼리 능력치 합계 합산
            if visited[i] == 1 and visited[j] == 1:
                start += s[i][j]
            elif visited[i] == 0 and visited[j] == 0:
                link += s[i][j]
    return abs(start - link)

# 가능한 모든 팀의 경우의 수를 백트래킹으로 뽑기
def backtrack(count, idx):
    global res
    # 종료 조건 : 한 팀이 완성됐을 때, 두 팀의 능력치 차이 계산하는 함수 호출
    if count == n // 2:
        res = min(res, make_team())
        # 다 끝날 때
        return

    for i in range(idx, n):
        if not visited[i]:
            visited[i] = 1
            backtrack(count + 1, i + 1)
            visited[i] = 0

backtrack(0, 0)
print(res)