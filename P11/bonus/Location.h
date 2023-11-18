#ifndef LOCATION_H
#define LOCATION_H

#include <iostream>
#include <string>

class Location {
public:
    Location(const std::string& filename, int line);

    bool operator<(const Location& rhs) const;
    bool operator==(const Location& rhs) const;
    bool operator!=(const Location& rhs) const;
    bool operator<=(const Location& rhs) const;
    bool operator>(const Location& rhs) const;
    bool operator>=(const Location& rhs) const;

    friend std::ostream& operator<<(std::ostream& os, const Location& location);

    static void next_word(); // Added static method

private:
    std::string _filename;
    int _line;

    static std::string last_filename; // Added static text field
};

#endif

