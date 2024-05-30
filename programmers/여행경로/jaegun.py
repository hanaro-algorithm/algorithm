from collections import defaultdict

def solution(tickets):
    graph = defaultdict(list)

    for src, dst in tickets:
        graph[src].append(dst)

    for src in graph:
        graph[src].sort(reverse=True)

    stack = ["ICN"]
    path = []

    while stack:
        top = stack[-1]

        if graph[top]:
            stack.append(graph[top].pop())
        else:
            path.append(stack.pop())

    return path[::-1]