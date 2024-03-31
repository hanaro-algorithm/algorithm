from itertools import permutations


def solution(numbers):
    global permuList
    permuList = []

    '''
    # 순열 표준 라이브러리 사용 예
    for num in range(1, len(numbers) + 1):
        permuList.append(list(permutations(numbers, num)))
        print(permuList)
    '''

    answer = 0
    permutation(list(numbers))
    for num in permuList:
        print(num, isPrime(num))
        if (isPrime(num)): answer += 1

    return answer


def permutation(numbers):  # 순열 구하기
    storage = []

    if len(numbers) == 1:
        if int(numbers[0]) not in permuList:
            permuList.append(int(numbers[0]))
        return numbers  # 한글자면 반환

    for idx, current in enumerate(numbers):  # [1,2,3]
        numbers[0], numbers[idx] = numbers[idx], numbers[0]  # 첫번째 숫자와 순차적으로 순서 변경하기 [1,2,3] [2,1,3] [3,1,2]
        for result in permutation(numbers[1:]):  # 첫번째를 제외한 하위 순열 구하기
            # [1,2,3] => permutation([2,3]) => [23, 32]
            num = numbers[0] + ''.join(result)  # 첫번째에서 순열 더하기
            # 1 + '23' = 123  1 + '32' = 132
            if int(num) not in permuList:  # 숫자로 변경 및 중복 확인
                permuList.append(int(num))
            storage.append(num)  # 모든 순열의 경우의 수를 storage에 저장
            # storage = ['123', '132']

    return storage


def isPrime(num):
    if num <= 1:
        return False
    if (num == 2 or num == 3):
        return True
    for i in range(2, int(num ** 1 / 2) + 1):
        if num % i == 0:
            return False
    return True