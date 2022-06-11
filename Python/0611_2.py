def dfs(n,start,graph,visited):
    visited[start]=True
    for i in range(n):
        if visited[i]==False and graph[start][i]==1:
            visited=dfs(n,i,graph,visited)
    return visited

def solution(n, computers):
    answer = 0
    visited=[False]*n
    for start in range(n):
        if visited[start]==False:
            dfs(n,start,computers,visited)
            answer+=1
    return answer
print(solution(3,[[1,1,0],[1,1,0],[0,0,1]]))