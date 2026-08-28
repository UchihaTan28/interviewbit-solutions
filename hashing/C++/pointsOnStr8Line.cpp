#include<bits/stdc++.h>
int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

int Solution::maxPoints(vector<int> &A, vector<int> &B) {
        int n = A.size();
        if (n <= 1) return n;

        int maxPoints = 0;

        for (int i = 0; i < n; ++i) {
            unordered_map<string, int> slopes;
            int duplicates = 1;
            
            for (int j = i + 1; j < n; ++j) {
                if (A[i] == A[j] && B[i] == B[j]) {
                    ++duplicates;
                } else {
                    int dx = A[j] - A[i];
                    int dy = B[j] - B[i];
                    int g = gcd(dx, dy);
                    
                    // Normalize slope
                    dx /= g;
                    dy /= g;
                    
                    // Ensure the direction is consistent
                    if (dx < 0) {
                        dx = -dx;
                        dy = -dy;
                    }
                    
                    if (dx == 0) {
                        dy = 1; // Vertical line
                    }
                    
                    string slope = to_string(dx) + "," + to_string(dy);
                    slopes[slope]++;
                }
            }

            int currentMax = duplicates;
            for (const auto& pair : slopes) {
                currentMax = max(currentMax, pair.second + duplicates);
            }

            maxPoints = max(maxPoints, currentMax);
        }

        return maxPoints;
    }