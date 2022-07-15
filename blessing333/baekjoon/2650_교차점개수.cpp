#include<bits/stdc++.h>
using namespace std;
using pii = pair<int, int>;
 
vector<pii> p;
int n;
int to[5] = {0, 0, 2, 3, 1};
 
int main() {
    cin >> n;
    n /= 2;
    for (int i = 0; i < n; i++) {
        int a, b, c, d;
        cin >> a >> b >> c >> d;
        a = to[a];
        c = to[c];
        int x = a * 51 + b, y = c * 51 + d;
        if (a > 1) x += 51 - 2 * b;
        if (c > 1) y += 51 - 2 * d;
 
        p.emplace_back(min(x, y), max(x, y));
    }
    int ans = 0;
    int cross[55] = {0,};
    for (int i = 0; i < n; i++) {
        auto[a, b] = p[i];
        for (int j = 0; j < n; j++) {
            auto[c, d] = p[j];
            if (a < c && c < b && b < d) {
                ans++;
                cross[i]++;
                cross[j]++;
            }
        }
    }
    cout << ans << endl;
    cout << *max_element(cross, cross + n);
}
