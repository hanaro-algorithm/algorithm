def solution(clothes):
    from collections import defaultdict

    clothes_dict = defaultdict(list)

    for item, category in clothes:
        clothes_dict[category].append(item)

    combinations = 1
    for category in clothes_dict:
        combinations *= (len(clothes_dict[category]) + 1)

    answer = combinations - 1

    return answer