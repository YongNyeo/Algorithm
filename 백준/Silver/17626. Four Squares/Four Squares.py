import itertools
import math
import sys


def solution(n):
    if math.sqrt(n).is_integer():
        return 1

    squares = {i**2 for i in range(1, int(math.sqrt(n)) + 1)}

    for a in squares:
        if n - a in squares:
            return 2

    for (a, b) in itertools.combinations_with_replacement(squares, 2):
        if n - a - b in squares:
            return 3

    return 4


print(solution(int(sys.stdin.readline())))
