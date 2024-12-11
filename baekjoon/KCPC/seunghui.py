import sys
input = sys.stdin.readline

for _ in range(int(input())):
    n, k, t, m = map(int, input().split())
    score = {i: [0] * (k + 1) for i in range(1, n + 1)} #조별 점수
    cnt = [0] * (n + 1) #횟수
    time = [0] * (n + 1) #시간
    for idx in range(m):
        i, j, s = map(int, input().split())
        score[i][j] = max(score[i][j], s)
        cnt[i] += 1
        time[i] = idx
    result = sorted(score, key=lambda x:[-sum(score[x]),cnt[x],time[x]])
    print(result.index(t)+1)