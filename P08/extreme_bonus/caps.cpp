#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

int main(int argc, char* argv[])
{
	std::vector<std::string> caps;
	std::vector<std::string>* no_caps = new std::vector<std::string>();
	
	
	for(int i = 1; i < argc; ++i){
		std::string word = argv[i];
		
		if(!word.empty()){
			if(isupper(word[0])){
				caps.push_back(word);
			} 
			else{
				no_caps->push_back(word);
				
			}
		}
	}
	
	std::sort(caps.begin(), caps.end()); // sort caps vector by natural order
	
	std::sort(no_caps->begin(), no_caps->end(), [](const std::string& a,const std::string& b){
		if(a.length()==b.length()){
			return a<b;
		}
		return a.length()<b.length();
		
	});
	
	
	
	std::cout<<"Capitalized: "<<std::endl;
	for(const auto &word : caps){
		std::cout<<word<<std::endl;
	}
	std::cout<<'\n';
	std::cout<<"Lower Case: "<<std::endl;
	for(const auto &word : *no_caps){
		std::cout<<word<<std::endl;
	}
	
	delete no_caps;
	return 0;
	
}


