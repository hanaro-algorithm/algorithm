import sys
from itertools import permutations

input = sys.stdin.readline

words = [input().rstrip() for _ in range(6)]
answer = []
isTrue = False

words_permu = permutations(words, 3)

def check(arr):
    words_check = words.copy()
    #가로 체크
    for a in arr:
        if a not in words_check:
            return False
        else:
            words_check.remove(a)
    # 세로 체크
    for i in range(3):
        temp = arr[0][i] + arr[1][i] + arr[2][i]
        if temp not in words_check:
            return False
        else:
            words_check.remove(temp)
    return True

for word in words_permu:
    answer = list(word)
    if check(answer):
        isTrue = True
        break

if isTrue:
    for a in answer:
        print(a)
else:
    print(0)