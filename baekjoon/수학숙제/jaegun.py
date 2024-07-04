import sys

n = int(sys.stdin.readline())

letters = []
for _ in range(n):
    letters.append(input())

numbers = []
for letter in letters:
    num = ''
    for char in letter:
        if char.isdigit():
            num += char
        else:
            if num:
                numbers.append(int(num))
                num = ''
    if num:
        numbers.append(int(num))

numbers.sort()

for number in numbers:
    print(number)