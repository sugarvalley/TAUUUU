import random
import pytest

from main import find_path


@pytest.fixture
def board():
    ROWS = 5
    COLS = 5

    board = [['.' for _ in range(COLS)] for _ in range(ROWS)]
    for row in range(ROWS):
        for col in range(COLS):
            if random.random() < 0.3:
                board[row][col] = 'X'

    start_row, start_col = random.choice([(0, i) for i in range(COLS)] + [(i, 0) for i in range(ROWS)])
    end_row, end_col = random.choice([(ROWS-1, i) for i in range(COLS)] + [(i, COLS-1) for i in range(ROWS)])
    board[start_row][start_col] = 'S'
    board[end_row][end_col] = 'E'

    return board


class TestFindPath:
    def test_path_is_valid(self, board):
        start_row, start_col = self.get_start_pos(board)
        end_row, end_col = self.get_end_pos(board)

        path = find_path(start_row, start_col, end_row, end_col)
        assert self.is_path_valid(path, board) is True

    def test_cannot_go_behind_board(self, board):
        start_row, start_col = self.get_start_pos(board)
        end_row, end_col = self.get_end_pos(board)

        path = find_path(start_row, start_col, end_row, -1)
        assert path is None

    def test_cannot_visit_field_twice(self, board):
        start_row, start_col = self.get_start_pos(board)
        end_row, end_col = self.get_end_pos(board)

        path = find_path(start_row, start_col, end_row, end_col)
        if path is None:
            assert True
        else:
            assert len(set(path)) == len(path)

    @staticmethod
    def get_start_pos(board):
        for row in range(len(board)):
            for col in range(len(board[0])):
                if board[row][col] == 'S':
                    return row, col

    @staticmethod
    def get_end_pos(board):
        for row in range(len(board)):
            for col in range(len(board[0])):
                if board[row][col] == 'E':
                    return row, col

    @staticmethod
    def is_path_valid(path, board):
        if not path:
            return False

        rows = len(board)
        cols = len(board[0])
        visited = set()
        for row, col in path:
            if row < 0 or row >= rows or col < 0 or col >= cols:
                return False
            if board[row][col] == 'X':
                return False
            if (row, col) in visited:
                return False
            visited.add((row, col))

        return True
