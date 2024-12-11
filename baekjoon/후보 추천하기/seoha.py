import sys
input = sys.stdin.readline

N = int(input())
total = int(input())
arr = list(map(int, input().split()))

picture = []
student = []

for i in range(len(arr)):
    if arr[i] not in student:
        if len(student) == N:
            #제거
            picture.sort(key=lambda x: (-x[1], -x[2]))
            student.remove(picture[-1][0])
            picture.pop(-1)

        student.append(arr[i])
        picture.append([arr[i], 0, i])
    else:
        for k in range(len(picture)):
            if picture[k][0] == arr[i]:
                picture[k][1] += 1

student.sort()
for s in student:
    print(s, end=' ')
