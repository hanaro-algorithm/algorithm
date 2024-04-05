def solution(n, lost, reserve):
    lost.sort()
    reserve.sort()
    for a in reserve:
        if a not in lost: # 여벌 O, 도난 X인 학생
            if ((a-1) in lost) and ((a-1) not in reserve):
                lost.remove(a-1)
            elif ((a+1) in lost) and ((a+1) not in reserve):
                lost.remove(a+1)
        else:
            lost.remove(a)
    return n - len(lost)