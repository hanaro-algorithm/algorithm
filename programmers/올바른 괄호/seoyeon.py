def solution(s):
    answer = True
    num1 = 0
    num2 = 0
    if len(s) % 2 != 0 : return False
    if s[0] == ")" or s[-1] == "(" : return False
    for i in s :
        if i == "(" :
            num1 += 1
        else : num2 += 1
        if num2 > num1 : return False
    if num1 == num2 : return True
    else : return False