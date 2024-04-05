from itertools import permutations


def isPrime(num):
    if num != 0 and num != 1:
        for i in range(2, num):
            if num % i == 0:
                return False
        return True
    else:
        return False


def solution(numbers):
    count = 0
    for i in range(1, len(numbers) + 1):
        arr = list(set(permutations(list(numbers), i)))
        for a in arr:
            sum = ""
            for index, value in enumerate(a):
                if index == 0 and value == '0':
                    break
                sum += value
            if sum != "":
                if (isPrime(int(sum))):
                    count += 1
    return count


print(solution("011"))
print(solution("17"))
