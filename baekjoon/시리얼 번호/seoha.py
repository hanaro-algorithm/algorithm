import sys
input = sys.stdin.readline

N = int(input())
numbers = [str(i) for i in range(10)]
serials = []

for _ in range(N):
    serial = input().rstrip()
    serial_sum = 0
    for s in serial:
        if s in numbers:
            serial_sum += int(s)
    serials.append([serial, serial_sum])

serials.sort(key = lambda x : (len(x[0]), x[1], x[0]))

for serial in serials:
    print(serial[0])