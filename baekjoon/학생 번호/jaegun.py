import sys
input = sys.stdin.readline

N = int(input())
students = list(str(input()).strip() for _ in range(N))
num_len = len(students[0])

for k in range(1, num_len + 1):
    numbers = []
    for student in students:
        numbers.append(student[-k::])

    if len(numbers) == len(set(numbers)):
        print(k)
        break