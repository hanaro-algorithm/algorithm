def solution(s):
    open=0
    close=0
    for a in s:
        if open >= close:
            if a == '(':
                open+=1
            else:
                close+=1
        else:
            return False
    return open==close