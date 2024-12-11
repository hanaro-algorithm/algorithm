import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    n, k, t, m = map(int, input().split())

    #[팀번호, [점수], 제출횟수, 마지막 제출 시간]
    score = [[num, [0 for _ in range(k)], 0, 0] for num in range(1, n+1)]

    for time in range(m):
        i, j, s = map(int, input().split())
        score[i-1][1][j-1] = max(score[i-1][1][j-1], s)
        score[i-1][2] += 1
        score[i-1][3] = time

    score.sort(key = lambda x : (-sum(x[1]), x[2], x[3]))

    for i in range(n):
        if score[i][0] == t:
            print(i+1)
            break