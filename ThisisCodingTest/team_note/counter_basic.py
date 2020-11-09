from collections import Counter

data = ['A', 'A', 'A', 'B', 'B', 'C', 'C', 'D']

counter = Counter(data)
print(counter)
print(dict(counter))
print(list(counter))
print(counter['A'])
print(counter['B'])