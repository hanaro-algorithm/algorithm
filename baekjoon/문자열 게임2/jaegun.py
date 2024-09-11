import sys
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    w = input().rstrip()
    k = int(input())

    count_char_dict = {}

    for char in w:
        count_char_dict[char] = count_char_dict.get(char, 0) + 1

    check = False
    max_answer = -1
    min_answer = len(w)

    check_dict = {}

    for i in range(len(w)):
        if count_char_dict[w[i]] < k:
            continue

        check = True
        check_dict[w[i]] = check_dict.get(w[i], []) + [i]

    for key, value_list in check_dict.items():
        for i in range(len(value_list) - k + 1):
            max_answer = max(max_answer, value_list[i+k-1] - value_list[i] +1)
            min_answer = min(min_answer, value_list[i + k - 1] - value_list[i] + 1)

    if check:
        print(min_answer, max_answer)
    else:
        print(-1)