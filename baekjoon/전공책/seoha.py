import sys
from itertools import combinations
input = sys.stdin.readline

T = input().rstrip()
N = int(input())
books = []
nums = [i for i in range(N)]
result = 0
isPossible = False

for _ in range(N):
    a, b = input().split()
    result += int(a)
    books.append([int(a), b])

for i in range(1, N+1): # 조합 요소 1 ~ N개 만들기 : (1), (1,3), (1,2,3) ...
    comb_list = combinations(nums, i)
    for combs in comb_list:
        temp_str = '' # 한 문자열에 모든 책 이름 저장
        temp_price = 0

        for comb in combs:
            temp_str += books[comb][1]
            temp_price += books[comb][0]

        temp_str_visited = [False] * len(temp_str)

        isSuccess = True # 해당 조합으로 T 완성 가능한지 확인
        for word in T:
            flag = False # 임시 문자열에 T의 문자가 포함되는지 확인
            for j in range(len(temp_str)):
                if word == temp_str[j] and not temp_str_visited[j]:
                    temp_str_visited[j] = True
                    flag = True
                    break
            if not flag:
                isSuccess = False
                break

        if isSuccess:
            isPossible = True # 한 번이라도 완성됨
            result = min(result, temp_price)

if isPossible:
    print(result)
else:
    print(-1)