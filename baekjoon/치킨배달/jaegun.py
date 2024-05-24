from itertools import combinations

n, m = map(int, input().split())
chicken = []
house = []

# 일반 집, 치킨 집 좌표 구하기
for i in range(n):
    data = list(map(int, input().split()))
    for j in range(n):
        if data[j] == 1:
            house.append((i, j)) # 일반 집
        elif data[j] == 2:
            chicken.append((i, j)) # 치킨 집

# 모든 치킨 집의 개수 중 M개의 치킨집을 고르기
candidates = list(combinations(chicken, m))

print(house)
print(candidates)
