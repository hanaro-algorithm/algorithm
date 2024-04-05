# https://school.programmers.co.kr/learn/courses/30/lessons/42862
def solution(n, lost, reserve):
    answer = n
    tmp = []
    for i in reserve :
        if i in lost :
            lost.remove(i)
        else :
            tmp.append(i)
    for i in tmp :
        if i-1 in lost : 
            lost.remove(i-1)
        elif i+1 in lost :
            lost.remove(i+1)
    answer -= len(lost)
    return answer