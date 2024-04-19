# 연산자 3개만 (+, -, *)
from itertools import permutations

def calc(op, num1, num2):
    num1=int(num1)
    num2=int(num2)
    if op == '+':
        return str(num1+num2)
    elif op == '-':
        return str(num1-num2)
    elif op == '*':
        return str(num1*num2)

def solution(expression):
    answer = []
    operation=[]
    num=[]
    curr=0

    # 문자열 나누기
    for idx, s in enumerate(expression):
        if s in ['+','-','*']:
            num.append(expression[curr:idx])
            num.append(s)
            operation.append(s)
            curr=idx+1
    num.append(expression[curr:])

    operation=set(operation)
    arr = list(set(permutations(operation, len(operation))))

# num: 숫자와 연산자 분리한 배열
# arr: 연산자 우선순위 조합
    next=[]
    for seq in arr:
        temp=num.copy()
        for op in seq:
            for i in range(len(temp)-1):
                if temp[i+1] == op:
                    if temp[i]=='n':
                        num1=next.pop(-1)
                    else:
                        num1 = temp[i]
                    num2 = temp[i+2]
                    next.append(calc(op, num1, num2))
                    temp[i]='n'
                    temp[i+1]='n'
                    temp[i+2]='n'
                elif temp[i]!='n':
                    next.append(temp[i])
            if len(next)!=1:
                if temp[-1]!='n':
                    next.append(temp[-1])
            temp=next.copy()
            next.clear()
        answer.append(abs(int(temp.pop())))
    return max(answer)

a="50*6-3*2"
b="100-200*300-500+20"
print(solution(b))
