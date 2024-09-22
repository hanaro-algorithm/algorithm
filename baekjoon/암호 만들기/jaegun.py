import sys
input = sys.stdin.readline
from itertools import combinations

L, C = map(int, input().split())
words = list(map(str, input().split()))

# 모음과 자음을 분리
vowels = set('aeiou')
vowel_list = []
consonant_list = []

# 주어진 문자를 모음과 자음으로 나누기
for word in words:
    if word in vowels:
        vowel_list.append(word)
    else:
        consonant_list.append(word)

# 정답 변수
passwords = []

# 최소 1개의 모음과 최소 2개의 자음을 포함해야 한다.
for i in range(1, len(vowel_list) + 1):  # 모음을 1개 이상 뽑을 때
    for j in range(2, len(consonant_list) + 1):  # 자음을 2개 이상 뽑을 때
        if i + j == L:  # 총 문자의 개수가 L이 되어야 함
            for v_comb in combinations(vowel_list, i):
                for c_comb in combinations(consonant_list, j):
                    passwords.append(''.join(sorted(v_comb + c_comb)))

for password in sorted(passwords):
    print(password)