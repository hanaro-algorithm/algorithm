import sys
input = sys.stdin.readline

N, M = map(int, input().split())

words = {}
for _ in range(N):
    # 문자열 입력값으로 받기
    word = input().rstrip()

    # 문자가 문자 딕셔너리에 있는 경우 횟수 추가
    if word in words:
        words[word] += 1
    else:
        words[word] = 1

# 길이가 M 이상인 것들만 가져오기
filtered_words = {}

for word, count in words.items():
    if len(word) >= M:
        filtered_words[word] = count

# 정렬
# 1. 자주 나오는 순서 : -x[1]
# 2. 해당 단어의 길이가 긴 순서 len(x[0])
# 3. 알파펫 사전 순 x[0]
sorted_words = sorted(filtered_words.items(), key=lambda x : (-x[1], -len(x[0]), x[0]))

for word, count, in sorted_words:
    print(word)
