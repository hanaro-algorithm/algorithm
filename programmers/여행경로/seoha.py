def solution(tickets):
    routes = dict()

    for start, end in tickets:
        routes[start] = routes.get(start, []) + [end]

    for r in routes.keys():
        routes[r].sort(reverse=True)

    st = ["ICN"]
    path = []

    while st:
        top = st[-1]
        if top not in routes or len(routes[top]) == 0:
            path.append(st.pop())
        else:
            st.append(routes[top][-1])
            routes[top] = routes[top][:-1]
    answer = path[::-1]
    return answer


tickets1=[["ICN", "AAA"], ["ICN", "CCC"], ["CCC", "DDD"], ["AAA", "BBB"], ["AAA", "BBB"], ["DDD", "ICN"], ["BBB", "AAA"]]
tickets2=[["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]
tickets3=[["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]
print(solution(tickets3))