import sys

N, M, B = map(int, sys.stdin.readline().split())

ground = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

time = sys.maxsize
height = 0

for i in range(257):
    use = 0
    take = 0

    for j in range(N):
        for k in range(M):
            if ground[j][k] > i:
                take += ground[j][k] - i
            else:
                use += i - ground[j][k]
    if take + B >= use:
        if take*2 + use <= time:
            time = take * 2 + use
            height = i

print(time, height)
