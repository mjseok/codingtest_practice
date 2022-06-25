from itertools import permutations
def solution(n):
    answer = [0]
    def dfs(board,curCol):
        if curCol in board:
            return
        curRow=len(board)
        for row,col in enumerate(board):
            if abs(row-curRow)==abs(col-curCol):
                return
        board.append(curCol)
        if len(board)==n:
            answer[0]+=1
        for col in range(n):
            dfs(board[:],col)

    for i in range(n):
        board=[]
        dfs(board,i)
    return answer[0]
print(solution(4))

