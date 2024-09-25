import sys
input = sys.stdin.readline

n = int(input())
time1 = 0
time2 = 0
one = 0
two = 0
flag1 = 0
flag2 = 0

for _ in range(n):
    team, time = map(str, input().split())
    m,s = map(int, time.split(":"))

    if team == '1':
        one += 1
        if one > two:
            if flag1 == 0:
                time1 += 48 * 60 - (60 * m + s)
            flag1 = 1
        elif one == two:
            if flag2 == 1:
                time2 -= 48 * 60 - (60 * m + s)
            flag2 = 0
    else:
        two += 1
        if one < two:
            if flag2 == 0:
                time2 += 48 * 60 - (60 * m + s)
            flag2 = 1
        elif one == two:
            if flag1 == 1:
                time1 -= 48 * 60 - (60 * m + s)
            flag1 = 0

print("{:0>2}:{:0>2}".format(time1 // 60, time1 % 60))
print("{:0>2}:{:0>2}".format(time2 // 60, time2 % 60))