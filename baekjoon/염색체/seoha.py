import sys

input = sys.stdin.readline

T = int(input())
arr = ['A', 'B', 'C', 'D', 'E', 'F']

for _ in range(T):
    chrom = input().rstrip()
    temp = []
    pre = ''
    flag = 0

    # 문자 하나만 담기
    for x in chrom:
        if x != pre:
            temp.append(x)
        pre = x

    # 단계별로 체크
    for a in temp:
        if flag == 0 or flag == 4:
            if a in arr:
                if a == 'A':
                    flag = 2
                else:
                    flag = 1
            else:
                flag = -1
        elif flag == 1:
            if a == 'A':
                flag = 2
            else:
                flag = -1
        elif flag == 2:
            if a == 'F':
                flag = 3
            else:
                flag = -1
        elif flag == 3:
            if a == 'C':
                flag = 4
            else:
                flag = -1
        else:
            flag = -1

    if flag != -1:
        print("Infected!")
    else:
        print("Good")