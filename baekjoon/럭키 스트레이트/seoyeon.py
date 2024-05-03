n = input()
k = len(n)//2

left = list(map(int, n[:k]))
right = list(map(int, n[k:]))

if sum(left) == sum(right):
    print("LUCKY")
else:
    print("READY")