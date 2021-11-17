def solution(n, words):
    answer = [0,0]
    turn=0
    num=0
    use=[words[0]]
    for i in range(1,len(words)):
        num+=1
        turn+=1
        if words[i-1][-1]==words[i][0] and words[i] not in use:
            use.append(words[i-1])
        else:
            answer[0]=num%n+1
            answer[1]=turn//n+1
            break
    return answer
#print(solution(3,["tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"]))
#print(solution(5,["ohello", "ohello", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"]))
#print(solution(2,["hello", "one", "even", "never", "now", "world", "draw"]))