import sys
input = sys.stdin.readline

t = int(input().rstrip())
infect = False
for _ in range(t):
    string = input().rstrip()
    infected = True
    index = 0

    if string[0] in 'ABCDEF':
        index += 1
    if string[index] == 'A':
        for i in range(index, len(string)):
            if string[i] == 'A': index += 1
    if string[index] == 'F':
        for i in range(index, len(string)):
            if string[i] == 'F': index += 1
    if string[index] == 'C':
        for i in range(index, len(string)):
            if string[i] == 'C': index += 1

    if index == len(string) - 1 and string[index] in 'ABCDEF':
        print('Infected!')
    elif index == len(string):
        print('Infected!')
    else:
        print('Good')