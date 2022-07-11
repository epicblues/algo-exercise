#include<bits/stdc++.h>
using namespace std;
int n,m;
int board[50][50];
int black[8][8] ={
    0,1,0,1,0,1,0,1,
    1,0,1,0,1,0,1,0,
    0,1,0,1,0,1,0,1,
    1,0,1,0,1,0,1,0,
    0,1,0,1,0,1,0,1,
    1,0,1,0,1,0,1,0,
    0,1,0,1,0,1,0,1,
    1,0,1,0,1,0,1,0
};
int white[8][8] = {
    1,0,1,0,1,0,1,0,
    0,1,0,1,0,1,0,1,
    1,0,1,0,1,0,1,0,
    0,1,0,1,0,1,0,1,
    1,0,1,0,1,0,1,0,
    0,1,0,1,0,1,0,1,
    1,0,1,0,1,0,1,0,
    0,1,0,1,0,1,0,1
};
int minimum = 2501;

void comp(int x,int y){
    int cnt =0;
    int cnt2= 0;
    for(int i=0;i<8;i++){
        if(cnt > minimum && cnt2 >minimum) return;
        for(int j=0;j<8;j++){
            if(board[x+i][y+j] !=white[i][j])
                cnt++;
            else if(board[x+i][y+j] !=black[i][j])
                cnt2++;
        }
    }
    int result = min(cnt,cnt2);
    minimum = min(result,minimum);
}


int main(){
    cin >> n >> m;
    
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            char a;
            cin >> a;
            if(a == 'W')
                board[i][j] = 1;
            else
                board[i][j] = 0;
        }
    }

    m-=8;
    n-=8;
    
    for(int i=0;i<=n;i++){
        for(int j=0;j<=m;j++){
            comp(i,j);
        }
    }
    cout << minimum;
}