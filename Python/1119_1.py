def solution(dirs):
    move=set()
    d = {'U': (0,1), 'D': (0, -1), 'R': (1, 0), 'L': (-1, 0)} 
    x,y=0,0
    for dir in dirs:
        dx,dy=x+d[dir][0],y+d[dir][1]
        if -5<=dx<=5 and -5<=dy<=5:
            move.add((x,y,dx,dy))
            move.add((dx,dy,x,y))
            x,y=dx,dy
    
    return len(move)//2
print(solution("LRLRL"))