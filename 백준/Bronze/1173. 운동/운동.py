N, m, M, T, R = map(int, input().split()) 
X = m 
T_t = 0 
R_t = 0
if m + T > M:
    T_t = -1
while 0 <= T_t < N:
    if X + T <= M:
        X += T
        T_t += 1
    else:
        X-=R
        if X < m: X = m
        R_t+=1
print(T_t + R_t)