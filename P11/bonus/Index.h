#ifndef INDEX_H
#define INDEX_H

#include <iostream>
#include <map>
#include <set>
#include "Location.h"

class Index {
private:
    using Word = std::string;
    using Locations = std::set<Location>;
    std::map<Word, Locations> _index;

public:
    // Method to add a word to the index
    void add_word(const Word& word, const Location& location);

    // Friend function for streaming out
    friend std::ostream& operator<<(std::ostream& os, const Index& index);
};

#endif // INDEX_H

