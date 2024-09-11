n = int(input())
answer = []

for _ in range(n):
    result = ''
    num = input()
    for i in num:
        if i.isdigit():
            result += i
        else:
            if result != '':
                answer.append(int(result))
                result = ''
    if result != '':
        answer.append(int(result))

answer.sort()
for i in answer:
    print(i)