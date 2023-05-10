import random

# board size
ROWS = 5
COLS = 5

# randomly generate obstacles
board = [['.' for _ in range(COLS)] for _ in range(ROWS)]
for row in range(ROWS):
    for col in range(COLS):
        if random.random() < 0.3:  # 30% chance of obstacle
            board[row][col] = 'X'

# place start and end points
start_row, start_col = random.choice([(0, i) for i in range(COLS)] + [(i, 0) for i in range(ROWS)])
end_row, end_col = random.choice([(ROWS-1, i) for i in range(COLS)] + [(i, COLS-1) for i in range(ROWS)])
board[start_row][start_col] = 'S'
board[end_row][end_col] = 'E'

# find path
def find_path(start_row, start_col, end_row, end_col):
    path = [(start_row, start_col)]
    row, col = start_row, start_col
    while row != end_row or col != end_col:
        if row < end_row:
            row += 1
        elif row > end_row:
            row -= 1
        if col < end_col:
            col += 1
        elif col > end_col:
            col -= 1
        if board[row][col] == 'X':
            return None  # path blocked
        path.append((row, col))
    return path

path = find_path(start_row, start_col, end_row, end_col)

# print board with start, end, obstacles, and path
for row in range(ROWS):
    for col in range(COLS):
        if board[row][col] == 'S':
            print('A', end=' ')
        elif board[row][col] == 'E':
            print('B', end=' ')
        elif board[row][col] == 'X':
            print('X', end=' ')
        elif path and (row, col) in path:
            print('*', end=' ')
        else:
            print('.', end=' ')
    print()

# export board to file with path
with open('board.txt', 'w') as f:
    for row in range(ROWS):
        for col in range(COLS):
            if board[row][col] == 'S':
                f.write('A')
            elif board[row][col] == 'E':
                f.write('B')
            elif board[row][col] == 'X':
                f.write('X')
            elif path and (row, col) in path:
                f.write('*')
            else:
                f.write('.')
            if col < COLS-1:
                f.write(' ')
        f.write('\n')

