#include <iostream>
#include <fstream>
#include <sstream>
#include <algorithm> // for std::transform
#include <cctype>    // for std::tolower
#include "Index.h"

// Helper function to remove punctuation and convert to lowercase
std::string process_word(const std::string& word) {
    std::string result;
    std::transform(word.begin(), word.end(), std::back_inserter(result), [](unsigned char c) {
        return std::tolower(c);
    });
    result.erase(std::remove_if(result.begin(), result.end(), ::ispunct), result.end());
    return result;
}

int main(int argc, char* argv[]) {
    if (argc < 2) {
        std::cerr << "Usage: " << argv[0] << " <filename1> <filename2> ..." << std::endl;
        return 1;
    }

    Index index;

    for (int i = 1; i < argc; ++i) {
        std::ifstream file(argv[i]);
        if (!file.is_open()) {
            std::cerr << "Error opening file: " << argv[i] << std::endl;
            continue;
        }

        std::string line;
        int line_number = 1;

        while (std::getline(file, line)) {
            std::istringstream iss(line);
            std::string word;
            while (iss >> word) {
                // Process the word (remove punctuation and convert to lowercase)
                std::string processed_word = process_word(word);

                // Skip empty words
                if (processed_word.empty()) {
                    continue;
                }

                // Add the word to the index with the corresponding location
                index.add_word(processed_word, Location(argv[i], line_number));
            }
            ++line_number;
        }

        file.close();
    }

    // Print the index
    std::cout << "Index\n=====\n" << index;

    return 0;
}

