def solution(n, lost, reserve):
    answer = n  # 체육복을 가져온 학생 수

    # 읽어버림 & 여벌있음 -> 학생 제외
    just_lost = set(lost) - set(reserve)
    just_reserve = set(reserve) - set(lost)

    for l in just_lost:
        if (l - 1) in just_reserve:
            just_reserve.remove(l - 1)
        elif (l + 1) in just_reserve:
            just_reserve.remove(l + 1)
        else:
            answer -= 1

    return answer