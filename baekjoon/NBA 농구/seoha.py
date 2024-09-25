import sys

input = sys.stdin.readline

N = int(input())

def calc_time(t1, t2):
    t1_m, t1_s = map(int, t1.split(':'))
    t2_m, t2_s = map(int, t2.split(':'))
    return (t2_m*60 + t2_s) - (t1_m*60 + t1_s)

score = {1:0, 2:0}
win_time = {1:0, 2:0}
curr_time = "00:00" # 역전했을 때 시간
flag = 0 # 0: 무승부, 1: 1번팀 우승중, 2: 2번팀 우승중

for _ in range(N):
    team, time = input().rstrip().split()
    score[int(team)] += 1

    # 무승부였다가 한 팀이 점수 획득했을 때
    if flag == 0:
        if score[1] > score[2]:
            curr_time = time
            flag = 1
        elif score[1] < score[2]:
            curr_time = time
            flag = 2
    else:
        # 무승부가 되면
        if score[1] == score[2]:
            win_time[flag] += calc_time(curr_time, time)
            flag = 0

# 다 끝나고 무승부가 아닌 상태면
if flag != 0:
    win_time[flag] += calc_time(curr_time, "48:00")

for value in win_time.values():
    print(f'{value//60:02}:{value%60:02}')


