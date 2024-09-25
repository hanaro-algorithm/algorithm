import sys
input = sys.stdin.readline

N = int(input())

# 시간을 초로 변환하는 함수
def time_to_seconds(time):
    minutes, seconds = map(int, time.split(':'))
    return minutes * 60 + seconds

# 초를 문자열 시간으로 변환하는 함수
def seconds_to_time(total_seconds):
    minutes = total_seconds // 60
    seconds = total_seconds % 60
    return f'{minutes:02}:{seconds:02}'

# 변수
# 1팀, 2팀 경기 스코어
score_one = 0
score_two = 0

# 1팀, 2팀 경기 리드 타임
lead_time_one = 0
lead_time_two = 0

# 마지막 기록된 시간
last_time = 0

full_time = time_to_seconds('48:00')

for _ in range(N):
    score_team, score_time = input().split()
    score_time = time_to_seconds(score_time)

    if score_one > score_two:
        lead_time_one += score_time - last_time
    elif score_one < score_two:
        lead_time_two += score_time - last_time

    # 득점 팀에 따라
    if score_team == '1':
        score_one += 1
    else:
        score_two += 1

    # 득점 기록 저장
    last_time = score_time

if score_one > score_two:
    lead_time_one += full_time - last_time
elif score_one < score_two:
    lead_time_two += full_time - last_time

print(seconds_to_time(lead_time_one))
print(seconds_to_time(lead_time_two))