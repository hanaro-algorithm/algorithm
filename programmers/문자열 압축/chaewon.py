def solution(s):
    minimum = len(s)

    for num in range(1, len(s) // 2 + 1):
        idx = 0
        pattern = ''
        count = 1
        current_count = 0
        while True:
            if idx + num <= len(s):
                if idx == 0:  # 처음 탐색
                    pattern = s[idx:idx + num]  # 초기 패턴 지정
                else:
                    if s[idx:idx + num] == pattern:  # 패턴 동일
                        count += 1  # 카운트 증가
                    else:  # 패턴 동일하지 않음
                        current_count += num  # 기존 패턴 길이 저장
                        if count != 1:
                            current_count += len(str(count))  # 카운트 길이 저장
                        pattern = s[idx:idx + num]  # 새로운 패턴 지정
                        count = 1  # 카운트 초기화
            else:
                if pattern != '':
                    current_count += num
                if count != 1:
                    current_count += len(str(count))
                current_count += len(s[idx:])
                break
            idx = idx + num  # 다음 단위로 변경
        if current_count < minimum:
            minimum = current_count

    return minimum
