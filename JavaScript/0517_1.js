function solution(brown, yellow) {
    var answer = [];

    for(let x=3;x<brown/2;x++){
        for(let y=3;y<=x;y++){
            if(x*y===brown+yellow){
                if((x-2)*(y-2)===yellow && (x+y)*2-4===brown){
                    answer.push(x,y)
                }
            }
        }
    }
    return answer;
}