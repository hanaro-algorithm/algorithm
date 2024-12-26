import sys
input = sys.stdin.readline

def calc_distance(mbti1, mbti2):
    distance = 0
    for i in range(4):
        if mbti1[i] != mbti2[i]:
            distance += 1
    return distance

T = int(input())

for _ in range(T):
    N = int(input())
    mbti = list(input().split())
    result = 12

    if N > 32:
        result = 0
    else:
        for i in range(N):
            for j in range(i+1, N):
                for k in range(j+1, N):
                    temp = calc_distance(mbti[i], mbti[j]) + calc_distance(mbti[i], mbti[k]) + calc_distance(mbti[j], mbti[k])
                    result = min(result, temp)
    print(result)
