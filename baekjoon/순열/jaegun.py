import sys
input = sys.stdin.readline

# 백트래킹 함수
def backtrack(string, depth):
    if depth == len(string):
        permutation.append(''.join(result))
        return

    for i in range(len(string)):
        if not visited[i]:
            visited[i] = True
            result.append(string[i])
            backtrack(string, depth + 1)
            result.pop()
            visited[i] = False


while True:
    try:
        user_input = input().rstrip()
        if not user_input:  # 입력값이 없으면 탈출
            break

        string, number = user_input.split()
        number = int(number)

        result = []
        permutation = []  # 모든 순열을 담을 리스트
        visited = [False] * len(string)

        backtrack(string, 0)

        permutation.sort()

        if number <= len(permutation):
            answer = permutation[number - 1]  # 인덱스는 0부터 시작
        else:
            answer = "No permutation"

        print(f"{string} {number} = {answer}")

    except EOFError:
        break