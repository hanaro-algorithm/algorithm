import sys

input = sys.stdin.readline

S, E, Q = input().rstrip().split()

start = int(S[:2]) * 60 + int(S[3:])
end = int(E[:2]) * 60 + int(E[3:])
off = int(Q[:2]) * 60 + int(Q[3:])

attend = set()
leave = set()

while True:
    try:
        time, name = input().rstrip().split()
        t = int(time[:2]) * 60 + int(time[3:])
        if t <= start:
            attend.add(name)
        elif end <= t <= off:
            leave.add(name)
    except:
        break

print(len(attend & leave))