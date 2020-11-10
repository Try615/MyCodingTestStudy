# 순열
from itertools import permutations
# 조합
from itertools import combinations
# 중복 순열
from itertools import product
# 중복 조합
from itertools import combinations_with_replacement

data = ['A', 'B', 'C', 'D', 'E']

# -- 순열 --
print(list(permutations(data, 3)))
print(len(list(permutations(data, 3))))

# -- 조합 --
print(list(combinations(data, 3)))
print(len(list(combinations(data, 3))))

# -- 중복 순열 --
# repeat 미기입시 기본 1
print(list(product(data, repeat=3)))
print(len(list(product(data, repeat=3))))

# -- 중복 조합 --
print(list(combinations_with_replacement(data, 3)))
print(len(list(combinations_with_replacement(data, 3))))