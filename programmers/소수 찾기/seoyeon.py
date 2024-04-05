from itertools import permutations
import math

def isDecimal(num) :
    if(num <= 1) :
        return False 
    for i in range(2, int(math.sqrt(num) + 1)) :
        if num % i == 0 :
            return False
    return True

def solution(numbers) :
    li = list(numbers)
    allNums = set()
    for i in range(1, len(numbers) + 1):
        permutationList = permutations(li, i)
        for perm in permutationList:
            num = int(''.join(perm))
            allNums.add(num)
    answer = 0
    for num in allNums:
        if isDecimal(num):
            answer += 1 
    return answer