import sys
input = sys.stdin.readline

N, M, B = map(int, input().split())
ground = [list(map(int, input().split())) for _ in range(N)]

# 가능한 높이 범위 설정
min_height = min(min(row) for row in ground)
max_height = max(max(row) for row in ground)

best_time = int(1e9)
best_height = 0

# 브루트포스: 가능한 높이 모두 탐색
for target_height in range(min_height, max_height + 1):
    remove_blocks = 0
    add_blocks = 0

    for i in range(N):
        for j in range(M):
            if ground[i][j] > target_height:  # 블록 제거해야 하는 경우
                remove_blocks += ground[i][j] - target_height
            else:                             # 블록 추가해야 하는 경우
                add_blocks += target_height - ground[i][j]

    # 인벤토리에 있는 블록으로 충분히 쌓을 수 있는지 확인
    if add_blocks > remove_blocks + B:
        continue

    time = remove_blocks * 2 + add_blocks  # 블록 제거는 2초, 추가는 1초

    # 최적의 시간과 높이 업데이트
    if time <= best_time:
        best_time = time
        best_height = target_height

# 결과 출력
print(best_time, best_height)