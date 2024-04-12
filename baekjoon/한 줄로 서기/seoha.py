N = int(input())
arr = list(map(int, input().split()))
height = [0] * N

height[arr[0]] = 1

for i in range(1, N):
    find = arr[i]  # 찾을 왼쪽 count
    cnt = 0
    # 앞에서 부터 찾기
    for j, a in enumerate(height):
        if cnt == find and a == 0:
            height[j] = i + 1
            break
        # cnt 처리
        if a > i + 1 or a == 0:
            cnt += 1

for a in height:
    print(a, end=' ')
