#ifndef LOCATION_H
#define LOCATION_H

#include <iostream>
#include <string>

class Location {
private:
    std::string _filename;
    int _line;

public:
    Location(const std::string& filename, int line);

    // Comparison operators
    bool operator<(const Location& rhs) const;
    bool operator==(const Location& rhs) const;
    bool operator!=(const Location& rhs) const;
    bool operator<=(const Location& rhs) const;
    bool operator>(const Location& rhs) const;
    bool operator>=(const Location& rhs) const;

    // Friend function for streaming out
    friend std::ostream& operator<<(std::ostream& os, const Location& location);
};

#endif // LOCATION_H

