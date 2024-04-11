from collections import deque


def solution(people, limit):
    answer = 0
    people.sort()
    q = deque(people)

    while q:
        num = q.pop()  # 큰 값
        find = limit - num
        if q:
            if q[0] <= find:
                q.popleft()
        answer += 1
    return answer


people = [70, 50, 80]
limit = 100
print(solution(people, limit))
