number = list(map(int, list(input())))
n = len(number)

left = number[:n//2]
right = number[n//2:]

if sum(left) == sum(right):
    print("LUCKY")
else:
    print("READY")