N,M=map(int,input().split())
tmp=[]

def dfs():
    if len(tmp)==M:
        print(' '.join(map(str,tmp)))
    for i in range(1,N+1):
        if i not in tmp:
            tmp.append(i)
            dfs()
            tmp.pop()
dfs()
#백트래킹 문제