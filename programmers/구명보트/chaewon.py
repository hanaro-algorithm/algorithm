def solution(people, limit):
    answer = 0

    sorted_people = sorted(people, reverse=True)

    startIndex = 0
    endIndex = len(people) - 1

    while sorted_people:
        if endIndex < startIndex:
            break

        total = sorted_people[startIndex] + sorted_people[endIndex]
        if total <= limit:
            startIndex += 1
            endIndex -= 1
            answer += 1
        else:
            startIndex += 1
            answer += 1

    return answer