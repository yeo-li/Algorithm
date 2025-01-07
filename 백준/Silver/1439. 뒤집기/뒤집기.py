string = input()

one = 0
zero = 0

oj = 1
zj = 1

for ch in string:
    if ch == '0' and zj == 1:
        zj = 0
        oj = 1
        zero += 1
    elif ch == '1' and oj == 1:
        oj = 0
        zj = 1
        one += 1

if zero < one:
    print(zero)
else:
    print(one)