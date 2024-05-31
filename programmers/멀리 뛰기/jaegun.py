def solution(n):
    d = [0] * 2000

    d[1] = 1
    d[2] = 2

    for i in range(3, n + 1):
        d[i] = (d[i - 1] + d[i - 2]) % 1234567

    return d[n]