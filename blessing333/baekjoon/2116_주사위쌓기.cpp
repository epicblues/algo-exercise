#include<bits/stdc++.h>
using namespace std;
int n;
int dice[10000][6];
int to[6] = {5,3,4,1,2,0};
int answer = -1;

void func(int dir){
    int sum = 0;
    int counter;
    int next;
    for(int i=0;i<n-1;i++){
        counter = to[dir];
        next = dice[i][counter];
        int maximum = 0;
        //dir이랑 counter를 제외한 최댓값 더하기
        for(int j=0;j<6;j++){
            if(j == dir || j == counter) continue;
            maximum = max(maximum,dice[i][j]);
        }
        sum += maximum;
        // cout << maximum <<"\n";
        //다음 주사위에서 뭐가 바닥으로 갈지 찾기
        for(int j=0;j<6;j++){
            if(dice[i+1][j] == next){
                dir = j;
                break;
            }
        }
    }

    int maximum = 0;
    counter = to[dir];
    for(int j=0;j<6;j++){
        if(j == dir || j == counter) continue;
        maximum = max(maximum,dice[n-1][j]);
    }
    sum += maximum;
    // cout << "sum : " <<sum <<"\n\n";
    answer = max(sum,answer);
}

int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
    cin >> n;

    for(int i=0;i<n;i++){
        for(int j=0;j<6;j++){
            cin >> dice[i][j];
        }
    }

    for(int i=0;i<6;i++){
        func(i);
    }
    cout << answer;
}