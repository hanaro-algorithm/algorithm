import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    N, M = map(int, input().split())
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))

    result = 0
    A.sort(reverse=True)
    B.sort(reverse=True)
    min_B = B[-1]
    curr = 0

    for num in A:
        # B 최솟값 보다 작으면 계산 중지
        if num <= min_B:
            break
        # 현재 B의 값보다 크면 계산
        if num > B[curr]:
            result += M - curr
        else:
            # num보다 작은 B의 값 찾아서 curr 갱신
            for i in range(curr, M):
                if num > B[i]:
                    # 바꾼 값 적용해서 계산
                    curr = i
                    result += M - curr
                    break

    print(result)