data = input()
result = int(data[0])

for i in range(0, len(data)-1):
    if int(data[i]) <= 1 or int(data[i+1]) <= 1:
        result += int(data[i+1])
    else:
        result *= int(data[i+1])

print(result)