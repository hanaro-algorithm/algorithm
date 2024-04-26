lst = list(input())

num = dict()
num[lst[0]] = 1
pre = lst[0]
for i in range(1, len(lst)):
    if lst[i] == pre:
        continue

    pre = lst[i]
    if not lst[i] in num:
        num[lst[i]] = 1
    else :
        num[lst[i]] += 1

if len(num.keys()) == 1: print(0)
else: print(min(num.values()))