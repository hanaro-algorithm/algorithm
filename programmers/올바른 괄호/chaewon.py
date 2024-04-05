def solution(s):
    answer = True

    myStack = []

    for current in s:
        if current == "(":
            myStack.append(current)
        elif current == ")":
            if (len(myStack) == 0): return False
            myStack.pop()  # 맨 마지막

    if len(myStack) > 0: return False

    return True