def solution(board):
    answer = 0

    for idx_row in range(1, len(board)):
        for idx_col in range(1, len(board[0])):
            if board[idx_row][idx_col] == 1:
                board[idx_row][idx_col] = min(
                    [board[idx_row - 1][idx_col - 1], board[idx_row - 1][idx_col], board[idx_row][idx_col - 1]]) + 1

    answer = max(map(max, board)) ** 2
    return answer