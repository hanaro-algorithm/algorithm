import sys
input = sys.stdin.readline

data = sorted(input())
pal = dict()

for i in data:
    if i != "\n":
        if i in pal:
            pal[i] += 1
        else:
            pal[i] = 1

odd = 0

for i in pal:
    if pal[i] % 2 == 1:
        odd += 1

if odd > 1:
    print("I'm Sorry Hansoo")
else:
    front = ""
    back = ""
    oddStr = ""
    for i in pal:
        if pal[i] % 2 == 1:
            oddStr = i
        front += i * (int(pal[i])//2)
        back = (i * (int(pal[i])//2)) + back
    front += oddStr

    print(front+back)
