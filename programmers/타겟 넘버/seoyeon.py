def solution(numbers, target):
    # 모든 계산 결과 담기
    sum = [0]           
    answer = 0
    for i in numbers :      
        tmp = []
        for j in sum :
            tmp.append(j + i)
            tmp.append(j - i)
        sum = tmp
    # check
    for k in sum :
        if k == target :
            answer += 1
    return answer