import sys
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))

op = list(map(int, input().split()))
res_max = -1000000000
res_min = 1000000000

def back(depth, curr, plus, minus, multi, div):
    global res_max, res_min
    if depth == N:
        res_max = max(res_max, curr)
        res_min = min(res_min, curr)
        return
    if plus > 0:
        back(depth + 1, curr + A[depth], plus - 1, minus, multi, div)
    if minus > 0:
        back(depth + 1, curr - A[depth], plus, minus - 1, multi, div)
    if multi > 0:
        back(depth + 1, curr * A[depth], plus, minus, multi - 1, div)
    if div > 0:
        back(depth + 1, int(curr / A[depth]), plus, minus, multi, div - 1)

back(1, A[0], op[0], op[1], op[2], op[3])
print(res_max)
print(res_min)

"""
#시간 5868ms 

import sys
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))

nums = list(map(int, input().split()))
op_dict = {0:'+', 1:'-', 2:'*', 3:'/'}
res_max = -1000000000
res_min = 1000000000

op = []
for i in range(4):
    for _ in range(nums[i]):
        op.append(op_dict[i])
visited = [False] * len(op)

def back(curr, depth):
    global res_max, res_min
    if depth == len(op):
        res_max = max(res_max, curr)
        res_min = min(res_min, curr)
        return

    for i in range(len(op)):
        if not visited[i]:
            visited[i] = True
            temp = 0
            if op[i] == '+':
                temp = curr + A[depth + 1]
            elif op[i] == '-':
                temp = curr - A[depth + 1]
            elif op[i] == '*':
                temp = curr * A[depth + 1]
            elif op[i] == '/':
                if curr < 0 < A[depth + 1] or curr > 0 > A[depth + 1]:
                    temp = (abs(curr) // abs(A[depth+1])) * -1
                else:
                    temp = curr // A[depth + 1]
            back(temp, depth+1)
            visited[i] = False

back(A[0], 0)
print(res_max)
print(res_min)
"""