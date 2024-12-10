N=input()
s=0
for i in range(1,len(N)):
    R=1
    for j in range(i):R*=int(N[j])
    E=1
    for j in range(i, len(N)):E*=int(N[j])
    if R==E:s=1
if s:print("YES")
else: print("NO")