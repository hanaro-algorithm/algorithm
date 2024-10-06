import sys
input = sys.stdin.readline

def plus_zero(list):
    for i in range(len(list)):
        if len(list[i]) != 4:
            zeros = "0" * (4 - len(list[i]))
            list[i] = zeros + list[i]

    return list

def solution(address):
    a = address.split(':')

    # ::가 있으면 중간에 공백이 생긴다
    if '' in a:
        # 중간위치 파악
        i = a.index('')
        a.remove('') # '' 문자열들을 제거
        # 리스트의 개수가 8개가 될때가지 중간에 0000을 추가
        while len(a) < 8:
            a.insert(i, '0000')

    answer = plus_zero(a)
    print(':'.join(answer))

address = input().rstrip()
solution(address)