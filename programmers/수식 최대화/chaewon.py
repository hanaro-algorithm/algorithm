from itertools import permutations
import re

def solution(expression):
    maximum = 0

    op_permu = list(permutations(['*', '+', '-'], 3))  # 순열 구하기
    result = re.split(r'(/d+|[*+-])', expression)  # 문자 -> 리스트

    original_operand = list()
    original_operator = list()

    # 연산자와 피연산자 분리
    for i in result:
        if i in ['*', '+', '-']:
            original_operator.append(i)
        else:
            original_operand.append(int(i))

    for priority in op_permu:  # 순열 순회
        operand = original_operand[:]
        operator = original_operator[:]
        for current_op in priority:  # 연산자 우선순위 순회
            idx = 0
            while (True):  # 연산자 비교하고 연산하기

                if idx == len(operator):
                    break

                if operator[idx] == current_op:
                    num1, num2 = operand[idx], operand[idx + 1]
                    operand[idx] = calculate(operator[idx], num1, num2)

                    operand.pop(idx + 1)
                    operator.pop(idx)
                else:
                    idx += 1

        if abs(operand[0]) >= maximum:  # 최대값 비교
            maximum = abs(operand[0])

    return maximum


def calculate(op, num1, num2):
    if op == '+':
        return num1 + num2
    elif op == '-':
        return num1 - num2
    elif op == '*':
        return num1 * num2