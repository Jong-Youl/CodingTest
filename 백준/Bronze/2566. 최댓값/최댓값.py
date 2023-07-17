arr = [list(map(int, input().split())) for i in range(9)]

max_value = 0
x = 0
y = 0

for i in range(9):
    for j in range(9):
        if arr[i][j] >= max_value:
            max_value = arr[i][j]
            x = i+1
            y = j+1
        else:
            continue

print(max_value)
print(x,y)