function solution(rows, columns, queries) {
    var answer = [];
    const table=Array.from(Array(rows),()=>new Array(columns))
    let num=1
    for(let i=0;i<rows;i++){
        for(let j=0;j<columns;j++){
            table[i][j]=num;
            num++;
        }
    }
    
    for(query of queries){
        [x1,y1,x2,y2]=query
        const stack=[]
        x1-=1
        y1-=1
        x2-=1
        y2-=1
        for(let y=y1;y<y2;y++) stack.push(table[x1][y])
        for(let x=x1;x<x2;x++) stack.push(table[x][y2])
        for(let y=y2;y>y1;y--) stack.push(table[x2][y])
        for(let x=x2;x>x1;x--) stack.push(table[x][y1])

        const tmp=stack.pop()
        stack.unshift(tmp);
        answer.push(Math.min(...stack))

        for(let y=y1;y<y2;y++) table[x1][y]=stack.shift()
        for(let x=x1;x<x2;x++) table[x][y2]=stack.shift()
        for(let y=y2;y>y1;y--) table[x2][y]=stack.shift()
        for(let x=x2;x>x1;x--) table[x][y1]=stack.shift()
    }
    
    return answer;
}
console.log(solution(6,6,[[2,2,5,4],[3,3,6,6],[5,1,6,3]]))