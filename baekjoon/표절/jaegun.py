import sys
input = sys.stdin.readline

def solution(n, files):

    # files 오름차순 정
    files.sort()

    # 이분 탐색
    def binary_search(files, index):
        left, right = index, len(files)-1
        while left <= right:
            mid = (left + right) // 2
            if files[index] >= files[mid] * 0.9:
                left = mid + 1
            else:
                right = mid - 1

        return left - index - 1

    answer = 0
    for i in range(len(files)):
        answer += binary_search(files, i)

    return answer

n = int(input())
files = list(map(int, input().split()))

print(solution(n, files))