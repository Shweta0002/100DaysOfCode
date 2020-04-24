#include<iostream>
#include<cstring>
#include<algorithm>
using namespace std;

string extractStringAtKey(string s , int key){
	char *ch = strtok((char *)s.c_str() , " ");
	while(key>1){
		ch  = strtok(NULL , " ");
		key--;
	}
	return (string)ch;
}
int convertToInt(string s){
    int ans=0;
    int p =1;
    for(int i = s.length()-1 ; i>=0;i--){
        ans +=(s[i]-'0')*p;
        p *= 10;
    }
    return ans;
}
bool numerixCompare(pair<string ,string> s1 , pair<string ,string> s2){
    string key1 , key2;
    key1 = s1.second;
    key2 = s2.second;
    return convertToInt(key1)<convertToInt(key2);
}
bool lexiCompare(pair<string ,string> s1 , pair<string,string> s2){
    string key1 , key2;
    key1 = s1.second;
    key2 = s2.second;
    return key1<key2;
}

int main() {
	
	int n;
	cin>>n;
	cin.get();
	string a[100];
	for(int i=0;i<n;i++){
		getline(cin , a[i]);
	}
	int key;
	string ordering , reversal;
    cin>>key>>reversal>>ordering;
    pair<string , string> strPair[100];
    for(int i =0 ; i<n ; i++){
        strPair[i].first = a[i];
        strPair[i].second = extractStringAtKey(a[i] , key); 
    }
    if(ordering=="numeric"){
        sort(strPair , strPair+n , numerixCompare);

    }
    else{
        sort(strPair , strPair+n , lexiCompare);
    }

    if(reversal=="true"){
        for(int i =0 ;i<n/2 ;i++){
            swap(strPair[i] , strPair[n-i-1]);
        }
    }

    for(int i=0;i<n;i++){
        cout<<strPair[i].first<<endl;
    }

	return 0;
}