import sys

input = sys.stdin.readline

while True:
    line = input().rstrip()
    if line == '':
        break
    str, num = line.split()

    answer = []
    cnt = 0

    def dfs():
        global cnt

        if len(answer) == len(str):
            cnt += 1
            if cnt == int(num):
                print(f'{str} {num} = {"".join(answer)}')
                return
        for s in str:
            if s not in answer:
                answer.append(s)
                dfs()
                answer.pop()
        return

    max = 1
    for i in range(1, len(str) + 1):
        max *= i

    if int(num) > max:
        print(f'{str} {num} = No permutation')
    else:
        dfs()
