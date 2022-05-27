def dfs(start):
    visited[start]=True
    for i in connect[start]:
        if visited[i]==False:
            dfs(i)
computers=int(input())
pair=int(input())
n=0
connect=[[]*computers for _ in range(computers+1)]
visited=[False]*(computers+1)
for i in range(pair):
    x,y=map(int,input().split())
    connect[x].append(y)
    connect[y].append(x)
dfs(1)
for virus in visited:
    if(virus):
        n+=1
print(n-1)
