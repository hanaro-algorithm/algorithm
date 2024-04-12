from collections import deque
n = int(input())

check = []
check.append(input())       # 일단 하나 넣고
for i in range(n - 1):      # 나머지들 하나씩 볼건데
    words = deque(input())  # 덱으로 받고
    for j in range(len(words)) :    # 해당 문자 중에서
        tmp = ''.join(words)        # 일단 붙여서 봤을 때
        if tmp in check :           # 비교하는 대상에 속하면
            break                   # 빠져나오고
        words.rotate()              # 아니면 섞고 다시 비교
    else :                          # 근데 만약에, 비교하는 대상에 없으면
        check.append(''.join(words))    # check에 넣어준다.
print(len(check))