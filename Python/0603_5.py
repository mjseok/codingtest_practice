from collections import deque

def solution(n, computers):
    answer=0
    visited=[0 for i in range(len(computers))]
    def bfs(i):
        q=deque()
        q.append(i)
        while q:
            i=q.popleft()
            visited[i]=1
            for a in range(n):
                if computers[i][a] and not visited[a]:
                    q.append(a)
    for i in range(n):
        if not visited[i]:
            bfs(i)
            answer+=1
    print(visited)
    return answer
print(solution(3,[[1, 1, 0], [1, 1, 1], [0, 1, 1]]))
# 프로그래머스 네트워크 문제 다시 풀기