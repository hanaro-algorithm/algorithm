import sys
input = sys.stdin.readline

def count_zero(num):
    count = 0
    while num > 0:
        num //= 5
        count += num
    return count

def solution(M):
    start, end = 0, 5 * M
    answer = -1

    while start <= end:
        mid = (start + end) // 2

        # 제로 수 세기
        current_res = count_zero(mid)

        if current_res == M:
            answer = mid
            end = mid - 1
        elif current_res < M:
            start = mid + 1
        else:
            end = mid - 1

    return answer

M = int(input())
print(solution(M))