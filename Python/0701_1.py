N,M,V=map(int,input().split())
graph=[[0]*(N+1) for _ in range(N+1)]
visited=[0]*(N+1)

for i in range(M):
    a,b=map(int,input().split())
    graph[a][b]=graph[b][a]=1
def dfs(V):
    visited[V]=1
    print(V,end=' ')
    for i in range(1,N+1):
        if visited[i]==0 and graph[V][i]==1:
            dfs(i)
def bfs(V):
    queue=[V]
    visited[V]=1

    while queue:
        V=queue.pop(0)
        print(V,end=' ')
        for i in range(1,N+1):
            if visited[i]==0 and graph[V][i]==1:
                queue.append(i)
                visited[i]=1
dfs(V)
print()
visited=[0]*(N+1)
bfs(V)
