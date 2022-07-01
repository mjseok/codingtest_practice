import heapq

INF=int(1e9)

n,e=map(int,input().split())
start=int(input())
graph=[[] for _ in range(n+1)]
distance=[INF]*(n+1)

for _ in range(e):
    u,v,w=map(int,input().split())
    graph[u].append((b,w))

def dijkstra(start):
    pq=[]
    heapq.heappush(pq,(0,start))
    distance[start]=0

    while pq:
        dist,n_now=heapq.heappop(pq)

        if distance[n_now]<dist:
            continue
        for i in graph[n_now]:
            c=dist+i[1]
            if c<distance[i[0]]:
                distance[[i[0]]]=c
                heapq.heappush(pq,(c,i[0]))
dijkstra(start)
for i in range(1,n+1):
    if distance[i]==INF:
        print("INF")
    else:
        print(distance[i])