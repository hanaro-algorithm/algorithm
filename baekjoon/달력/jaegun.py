import sys
input = sys.stdin.readline

def solution(N, schedules):
    calendar = [0] * 367

    for s, e in schedules:
        calendar[s] += 1
        calendar[e + 1] -= 1

    width = 0
    height = 0
    answer = 0

    for i in range(1, 367):
        calendar[i] += calendar[i - 1]

        if calendar[i] == 0:
            answer += width * height
            width = 0
            height = 0
        else:
            width += 1
            height = max(height, calendar[i])

    answer += width * height

    return answer

N = int(input())
schedules = [list(map(int, input().split())) for _ in range(N)]

print(solution(N, schedules))