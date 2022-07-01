INF=int(1e9)

n,e=map(int,input().split())
start=int(input())
graph=[[]for i in range(n+1)]
visited=[False]*(n+1)
distance=[INF]*(n+1)

for _ in range(e):
    u,v,cost=map(int,input().split())
    graph[u].append((v,cost))

def node_choice():
    min_v=INF
    idx=0
    for i in range(1,n+1):
        if distance[i]<min_v and not visited[i]:
            min_v=distance[i]
            idx=i
    return idx
    
def dijkstra(start):
    distance[start]=0
    visited[start]=True
    for i in graph[start]:
        distance[i[0]]=i[1]
    for i in range(n-1):
        n_now=node_choice()
        visited[n_now]=True
        for j in graph[n_now]:
            c=distance[n_now]+j[1]
            if c < distance[j[0]]:
                distance[j[0]]=c
dijkstra(start)
for i in range(1,n+1):
    if distance[i]==INF:
        print("INF")
    else:
        print(distance[i])