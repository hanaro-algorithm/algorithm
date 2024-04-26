import math
str = input()
result = 0

for i in range(len(str)-1):
    if str[i] != str[i+1]:
        result += 1

print(int(math.ceil(result/2)))