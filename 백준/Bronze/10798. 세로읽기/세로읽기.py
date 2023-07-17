arr = [['*' for j in range(15)]for i in range(5)]

for i in range(5):
    lst = input()
    for idx, word in enumerate(lst):
         arr[i][idx] = word

for j in range(15):
    for i in range(5):
        if arr[i][j] == '*':
            continue
        print(arr[i][j], end = "")