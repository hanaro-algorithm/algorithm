import sys
input = sys.stdin.readline

# 시간 초과가 뜬다
def solution_2():
    N, K = map(int, input().split())
    temperature = list(map(int, input().split()))

    # 정답 변수
    max_sum = 0
    for start in range(N - K):
        current_sum = sum(temperature[start:start+K])
        max_sum = max(max_sum, current_sum)

    print(max_sum)

def solution():
    N, K = map(int, input().split())
    temperature = list(map(int, input().split()))

    # 첫 번째 구간의 합을 미리 계산
    current_sum = sum(temperature[:K])
    max_sum = current_sum

    # 슬라이딩 윈도우로 구간을 이동하면서 최대 합을 찾는다
    for start in range(1, N-K+1):
        # 구간을 한 칸 이동: 맨 앞 값을 빼고, 새로운 값을 더함
        current_sum = current_sum - temperature[start-1] + temperature[start+K-1]
        max_sum = max(max_sum, current_sum)

    print(max_sum)
solution()