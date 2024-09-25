import sys
input = sys.stdin.readline

def solution():

    N, d, k, c = map(int, input().split())
    belt = list(int(input()) for _ in range(N))

    # 슬라이딩 윈도우에 사용할 변수
    sushi_count = [0] * (d + 1)
    current_variety = 0

    for i in range(k):
        if sushi_count[belt[i]] == 0:
            current_variety += 1
        sushi_count[belt[i]] += 1

    max_variety = current_variety
    if sushi_count[c] == 0:
        max_variety += 1

    for i in range(1, N):
        remove_sushi = belt[i - 1]
        sushi_count[remove_sushi] -= 1
        if sushi_count[remove_sushi] == 0:
            current_variety -= 1

        new_sushi = belt[(i + k - 1) % N]
        if sushi_count[new_sushi] == 0:
            current_variety += 1
        sushi_count[new_sushi] += 1

        total_variety = current_variety
        if sushi_count[c] == 0:
            total_variety += 1

        max_variety = max(max_variety, total_variety)

    # 결과 출력
    print(max_variety)

solution()