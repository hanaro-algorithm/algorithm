from collections import Counter

T = list(input())  
N = int(input()) 
books = []
min_cost = float('inf')

for _ in range(N):
    C, W = input().split()
    books.append((int(C), W))

# 목표 문자열의 문자 개수 세기
target_count = Counter(T)

# 모든 책 조합 탐색
for i in range(1, 2 ** N):  # 1부터 2^N - 1까지
    selected_cost = 0
    combined_count = Counter()

    for j in range(N):  # 각 책 확인
        if i & (1 << j):  # j번째 책 선택
            selected_cost += books[j][0]
            combined_count.update(books[j][1])

    # 목표 문자열을 만들 수 있는지 확인
    if all(combined_count[c] >= target_count[c] for c in target_count):
        min_cost = min(min_cost, selected_cost)

print(min_cost if min_cost != float('inf') else -1)