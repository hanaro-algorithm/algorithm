dirX = [-1, 0, 1, 0]
dirY = [0, -1, 0, 1]  # 좌 하 우 상


def solution(maps):
    answer = BFS(maps)
    return answer


def BFS(maps):
    n = len(maps)  # x좌표
    m = len(maps[0])  # y좌표
    visited = [[0 for _ in range(m)] for _ in range(n)]  # 방문여부 확인

    myQueue = list()
    myQueue.append([0, 0])
    visited[0][0] = True  # 방문 체크

    while myQueue:
        x, y = myQueue.pop(0)  # 첫번째 요소 확인
        if [x, y] == [n - 1, m - 1]:
            return maps[n - 1][m - 1]

        for idx in range(4):
            x_point, y_point = x + dirX[idx], y + dirY[idx]  # x좌표, y좌표
            if isValidate(x_point, y_point, n, m) and maps[x_point][y_point] == 1 and not visited[x_point][y_point]:
                maps[x_point][y_point] = maps[x][y] + 1
                myQueue.append([x_point, y_point])
                visited[x_point][y_point] = True  # 방문 체크

    return -1


def isValidate(x, y, n, m):
    if x < 0 or x >= n or y < 0 or y >= m:
        return False
    return True