#include <iostream>
# include<cstring>
#include<algorithm>
using namespace std;
char *mystrtok(char *str , char delim){
    //string and a character
        static char *input =NULL;
        if(str !=NULL){
            //first call , input initialized
            input=str;
        }
        if(input==NULL){
            //if string is null
            return NULL;
        }
        char *output = new char[strlen(input)+1];
        int i=0;
        for(;input[i]!='\0';i++){
            if(input[i] !=delim){
                output[i]=input[i];
            }
            else{
                output[i]='\0';
                input = input + i + 1;
                return output;
            }
        }
        //corner case to handle end of the string
        output[i]='\0';
        input=NULL;
        return output;

    

}

int main() {
    char ch[100] = "this,is a new ,class";
    char *ptr = mystrtok(ch , ',');
    cout<<ptr<<endl;
    while(ptr!=NULL){
        ptr= mystrtok(NULL , ',');
        cout<<ptr<<endl;
    }
	// your code goes here
	return 0;
}
