N = input()
length = len(N)//2
left = N[:length]
right = N[length:]

if sum(list(map(int, left)))==sum(list(map(int, right))):
    print("LUCKY")
else:
    print("READY")
