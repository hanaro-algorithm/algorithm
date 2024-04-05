def solution(numbers, target):
    global answer
    answer = 0
    
    DFS(numbers, target, 0 + numbers[0], 1)
    DFS(numbers, target, 0 - numbers[0], 1)
    
    return answer

def DFS(numbers, target, current, depth):
    global answer
    if depth == len(numbers):
        if current == target: answer += 1
        return
    
    DFS(numbers, target, current + numbers[depth], depth + 1)
    DFS(numbers, target, current - numbers[depth], depth + 1)
        