lst = list(map(int,list(input())))

result = 0
while lst:
    current = lst.pop(0)
    if result == 0 or current == 0:
        result += current
        continue

    result *= current

print(result)