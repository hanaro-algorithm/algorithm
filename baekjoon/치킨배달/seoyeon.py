from collections import deque

N, M = map(int, input().split())  
arr = [list(map(int, input().split())) for _ in range(N)]

# n: 고른 치킨집 수 i: 고른 치킨집 번호

def dfs(n, i): 
    global result
    val = 0
    
    # 모든 치킨집을 고르고 거리 계산
    if n == M:
        for h in house:
            hr, hc = h[0], h[1]
            dist = 2*N

            for c in select:
                cr, cc = c[0], c[1]
                tmp = abs(hr-cr) + abs(hc-cc)
                if tmp < dist:
                    dist = tmp
            val += dist

        if val < result:
            result = min(val, result)
            return
        
	# 고른 집 제외 dfs
    for idx in range(i, K):
        select.append(chicken[idx])
        dfs(n+1, idx+1)
        select.pop()

chicken = deque([])
house = deque([])

select = deque([])
for a in range(N):
    for b in range(N):
        if arr[a][b] == 1:        # 집
            house.append((a, b))
        elif arr[a][b] == 2:      # 치킨집
            chicken.append((a, b))

K = len(chicken)             # 총 치킨집 수
result = N * 2 * len(house)      # 총 치킨거리 임의의 큰 값

for t in range(K):
    dfs(0, t)

print(result)