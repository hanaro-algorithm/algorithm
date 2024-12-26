from itertools import permutations

# 입력 처리
N = int(input())
strings = [input().strip() for _ in range(N)]

# 각 문자열의 내부 변경 횟수를 미리 계산
internal_changes = [sum(1 for i in range(1, len(s)) if s[i-1] != s[i]) for s in strings]

# 전체 최소 변경 횟수 초기화
min_changes = float('inf')

# 순열 탐색
for perm in permutations(range(N)):
    temp_changes = 0
    # 첫 번째 문자열의 내부 변경 횟수 더하기
    temp_changes += internal_changes[perm[0]]
    # 순열을 따라 연결하며 변경 횟수 계산
    for i in range(1, N):
        prev = strings[perm[i-1]]
        curr = strings[perm[i]]
        # 이전 문자열 끝과 현재 문자열 시작 비교
        if prev[-1] != curr[0]:
            temp_changes += 1
        # 현재 문자열의 내부 변경 횟수 추가
        temp_changes += internal_changes[perm[i]]
    # 최소 변경 횟수 업데이트
    min_changes = min(min_changes, temp_changes)

# 결과 출력
print(min_changes)