#include<bits/stdc++.h>
using namespace std;
int n;
int le[2001],ri[2001];
int dp[2001][2001];

int func(int l,int r){
    if(l == n || r == n) return 0;
    if(dp[l][r] != -1 ) return dp[l][r];
    dp[l][r] = 0;

    if(ri[r] < le[l]){
        dp[l][r] = ri[r] + func(l,r+1);
    }
    
    dp[l][r] =max(dp[l][r],max(func(l+1,r),func(l+1,r+1)));
    
    return dp[l][r];
}

int main(){
    long answer = 0;
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
    cin >> n;
    for(int i=0;i<n;i++){   
        cin >> le[i];
    }

    for(int i=0;i<n;i++){
        cin >> ri[i];
    }
    fill(&dp[0][0],&dp[0][0] + 2001 * 2001,-1);
    cout << func(0,0);

}