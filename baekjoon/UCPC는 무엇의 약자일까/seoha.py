import sys
input = sys.stdin.readline

arr = input().rstrip()
word = ['U', 'C', 'P', 'C']
flag = False

for a in arr:
    if len(word) != 0:
        if a == word[0]:
            word.pop(0)
    if len(word) == 0:
        flag = True

if flag:
    print("I love UCPC")
else:
    print("I hate UCPC")