import sys
input = sys.stdin.readline

def backtrack(A, B, C):
    global max_num
    if len(C) == len(A): # 만들어진 숫자가 A랑 같은 자릿수일때
        current_num = int(C)
        if current_num < B:
            max_num = max(max_num, current_num)
        return

    for i in range(len(A)):
        if not visited[i]:
            if C == '' and A[i] == '0':
                continue
            visited[i] = True
            backtrack(A, B, C+A[i])
            visited[i] = False

A, B = input().split()
B = int(B)

visited = [False] * len(A)
max_num = -1
backtrack(A, B, '')
print(max_num)