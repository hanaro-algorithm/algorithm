n = int(input())
words = [input() for _ in range(n)]
print(words)
li = []
for i in words:
    dict = {}
    for j in i :
        if j in dict :
            dict[j] += 1
        else :
            dict[j] = 1
    if dict not in li :
        li.append(dict)
    print(li)
print(len(li))