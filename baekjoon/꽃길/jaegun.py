# N과 정원 입력받기
n = int(input())
garden = [list(map(int, input().split())) for _ in range(n)]

# 꽃이 차지하는 5개의 좌표
dx = [0, 0, 0, -1, 1]
dy = [0, -1, 1, 0, 0]


# 특정 위치에 꽃을 심는 데 드는 비용 계산
def calculate(x, y):
    total_cost = 0
    flower_positions = []
    for i in range(5):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx < 0 or ny < 0 or nx >= n or ny >= n:
            return float('inf')  # 경계를 벗어나면 불가능한 위치로 간주
        flower_positions.append((nx, ny))
        total_cost += garden[nx][ny]
    return total_cost, flower_positions


# 꽃을 심을 수 있는지 확인
def check(occupied, positions):
    for pos in positions:
        if pos in occupied:
            return False  # 이미 심어진 곳이라면 False
    return True


# 최소 비용 저장할 변수
min_cost = float('inf')


# 브루트포스로 모든 위치에 대해 시도
def brute_force(occupied, flower_count, current_cost):
    global min_cost

    # 꽃 3개를 모두 심었다면 최소 비용을 갱신하고 종료
    if flower_count == 3:
        min_cost = min(min_cost, current_cost)
        return

    # 정원의 경계 안에서 꽃을 심을 수 있는 위치 탐색
    for i in range(1, n - 1):
        for j in range(1, n - 1):
            # 현재 위치에 꽃을 심는 데 드는 비용과 해당 좌표 계산
            cost, positions = calculate(i, j)

            # 이미 점령된 위치와 겹치지 않으면 꽃을 심을 수 있음
            if check(occupied, positions):
                new_occupied = occupied + positions  # 새로운 점령된 위치 추가
                brute_force(new_occupied, flower_count + 1, current_cost + cost)


# 시작
brute_force([], 0, 0)

print(min_cost)