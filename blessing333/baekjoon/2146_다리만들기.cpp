#include<bits/stdc++.h>
using namespace std;
int n;
int board[100][100];
bool visited[100][100];
int dx[] = {1,0,-1,0};
int dy[] = {0,1,0,-1};
vector<vector<pair<int,int>>> sections;

void divideSection(int x,int y,int id){
    vector<pair<int,int>> area;
    visited[x][y] = true;
    queue<pair<int,int>> q;
    q.push({x,y});
    area.push_back({x,y});
    while(!q.empty()){
        pair<int,int> cur = q.front(); q.pop();
        for(int i=0;i<4;i++){
            int nx = cur.first + dx[i];
            int ny = cur.second + dy[i];
            if(nx >= n || nx < 0 || ny >= n || ny < 0) continue;
            if(!visited[nx][ny] && board[cur.first][cur.second] == board[nx][ny]){
                visited[nx][ny] = true;
                q.push({nx,ny});
                area.push_back({nx,ny});
            }
        }
    }
    for(auto it : area){
        board[it.first][it.second] = id;
    }
    sections.push_back(area);
    
    
}
int main(){
    int sectionId = 1;
    cin >> n;
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            cin >> board[i][j];
        }
    }

    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(board[i][j] != 0 && !visited[i][j]){
                divideSection(i,j,sectionId++);
            }
        }
    }
    
    
    int result = 0;
    bool flag = false;
    vector<int> cnt(sections.size(),0);
    vector<int> resultList;

    while(true){ //간척사업 진행
        int idx=0;
        for(auto section : sections){
            cnt[idx]++;
            vector<pair<int,int>> tmp;
            for(auto it : section){
                for(int i=0;i<4;i++){
                    int nx = it.first+dx[i];
                    int ny = it.second+dy[i];
                    if(nx >= n || nx <0 || ny >= n || ny <0) continue;
                    if(board[nx][ny] == 0){
                        tmp.push_back({nx,ny});
                        board[nx][ny] = board[it.first][it.second];
                    }
                    else if(board[nx][ny] != board[it.first][it.second]){
                        flag = true;
                        int value1 = cnt[board[nx][ny]-1];
                        int value2 = cnt[board[it.first][it.second]-1];
                        // cout << "land 1 : " <<board[nx][ny]<<"  "<<value1<<"\n";
                        // cout << "land 2 : " <<board[it.first][it.second]<<"  "<<value2 <<"\n";
                        result = value1 + value2 -1;
                        resultList.push_back(result);       
                    }
                }
            }
            sections[idx++] = tmp;
        }
        if(flag) break;
    }
    cout << *min_element(resultList.begin(),resultList.end());
}
