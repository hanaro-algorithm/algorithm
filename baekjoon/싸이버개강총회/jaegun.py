import sys
input = sys.stdin.readline

S, E, Q = input().split()

def time_to_minutes(time):
    hour, minute = map(int, time.split(':'))
    return hour * 60 + minute

start = time_to_minutes(S)
end = time_to_minutes(E)
quit = time_to_minutes(Q)

entry_set = set()
exit_set = set()

while True:
    line = input().strip()
    if not line:
        break

    time_str, nickname = line.split()
    time = time_to_minutes(time_str)
    if time <= start:
        entry_set.add(nickname)

    if end <= time and time <= quit:
        exit_set.add(nickname)

result_set = entry_set & exit_set
print(len(result_set))