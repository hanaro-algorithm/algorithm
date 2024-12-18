import sys
input = sys.stdin.readline

n = int(input())
# 모든 자연수는 넷 혹은 그 이하의 제곱수의 합
def four_squares(n):
    # 224*224 = 50176
    L = set([i * i for i in range(1, 224)])

    # n이 1개 제곱수로 표현되는 지
    if n in L:
        return 1

    # n이 2개 제곱수로 표현되는 지
    for i in range(1, int(n**0.5)+1):
        if ( n - i*i ) in L: #i*i : 제곱수
            return 2

    # n이 3개 제곱수로 표현되는 지
    for i in range(1, int(n**(0.5)+1)):
        for j in range(1, int(n**0.5)+1):
            if ( n - i*i - j*j ) in L: #i*i, j*j : 제곱수
                return 3

    return 4

print(four_squares(n))