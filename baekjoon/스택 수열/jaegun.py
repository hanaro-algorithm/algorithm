n = int(input())
sequence = [int(input()) for _ in range(n)]

answer = []
stack = []
cnt = 1

for num in sequence:
    while cnt <= num:
        stack.append(cnt)
        answer.append('+')
        cnt += 1

    if stack[-1] == num:
        stack.pop()
        answer.append('-')
    else:
        print("NO")
        exit(0)

print('\n'.join(answer))