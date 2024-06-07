"""
효율성 테스트 3, 4 실패로 답안 참고
"""

def solution(phone_book):
    phone_book.sort()
    for i in range(len(phone_book)-1):
        if phone_book[i+1].startswith(phone_book[i]):
            return False
    return True

print(solution(["119", "97674223", "1195524421"]))

"""
실패 코드
from collections import deque

def solution(phone_book):
    phone_book.sort()
    check_book = deque(phone_book)
    for str in phone_book:
        check_book.popleft()
        for check in check_book:
            if check.startswith(str):
                return False
    return True
"""