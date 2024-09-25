import sys
input = sys.stdin.readline

n,m = map(int, input().split())
group = []
member = []
result = ''
for i in range(n):
    group.append(input().strip())
    num = int(input())
    member.append([input().strip() for _ in range(num)])
    member[i].sort()

for _ in range(m):
    quiz = input().strip()
    t = int(input())
    if t == 1:
        for m in range(n):
            if member[m].count(quiz) != 0:
                result += group[m] + "\n"
    else:
        for mem in member[group.index(quiz)]:
            result += mem + "\n"

print(result)
