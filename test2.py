n = int(input())
words = [input() for _ in range(n)]
print(words)
wordword = []
count = 0
for i in words :
    str = ''
    for j in i :
        str += j
    for j in i :
        str += j
    wordword.append(str)

for i in words :
    for j in wordword :
        if i not in j :
            count += 1
            break
    
print(count)

# li = []
# for i in words:
#     dict = {}
#     for j in i :
#         if j in dict :
#             dict[j] += 1
#         else :
#             dict[j] = 1
#     if dict not in li :
#         li.append(dict)
#     print(li)
# print(len(li))