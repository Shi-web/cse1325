#include "Index.h"
#include "Location.h" // Include Location.h for access to Location::next_word()

void Index::add_word(const Index::Word& word, const Location& location) {
    // Check if the word is already in the index
    auto it = _index.find(word);

    if (it == _index.end()) {
        // If not, add a new entry with the word and its location
        _index[word] = {location};
    } else {
        // If the word is already in the index, add the location to the existing set
        it->second.insert(location);
    }
}

std::ostream& operator<<(std::ostream& os, const Index& index) {
    // Iterate over the index and print each word and its locations
    for (const auto& entry : index._index) {
        Location::next_word(); // Ensure the first output for a new word includes the filename
        os << entry.first << ": ";
        for (const auto& location : entry.second) {
            os << location << ", ";
        }
        os << '\n';
    }
    return os;
}


