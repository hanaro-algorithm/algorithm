import sys
# import collections
input = sys.stdin.readline

word = list(input().rstrip())

# 펠린드롬
# 딕셔너리 사용
# 조건
# 1. 알파벳의 value 값이 전부 홀수면 안된다 -> 알파벳의 종류 중 하나만 홀수여야한다

# 딕셔너리에 넣기
# check_word = collections.Counter(word) : 이거 사용 가능
d = dict()
for i in word:
    if i not in d:
        d[i] = 1
    else:
        d[i] += 1

# 펠린드롬이 안되는 경우 체크
cnt = 0
mid = ''
for key, value in list(d.items()):
    # 알파벳의 종류 중 하나만 홀수이면
    if value % 2 == 1:
        # 홀수인 경우 체크
        cnt += 1
        mid = key # 가운데 숫자는 이 숫자여야 한다 예를 들어 AABBCCC에서는 C가 홀수개이므로 C가 중간에 와야한다
        if cnt >= 2:
            print("I'm Sorry Hansoo")
            exit()

# 문자열 만들기
result = ''
# mid를 중심으로 정렬 후 문자열 만들기 ex) AAAABBCCC -> AABC C CBAA

for key, value in sorted(list(d.items())):
    mid_value = value // 2
    result += key * mid_value

# 파이썬 문자열 뒤집기 : [::-1]
answer = result + mid + result[::-1]

print(answer)