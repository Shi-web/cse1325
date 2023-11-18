#include "Location.h"


std::string Location::last_filename = ""; // Initialize static member


Location::Location(const std::string& filename, int line)
    : _filename(filename), _line(line) {}

bool Location::operator<(const Location& rhs) const {
    if (_filename == rhs._filename) {
        return _line < rhs._line;
    }
    return _filename < rhs._filename;
}

bool Location::operator==(const Location& rhs) const {
    return (_filename == rhs._filename) && (_line == rhs._line);
}

bool Location::operator!=(const Location& rhs) const {
    return !operator==(rhs);
}

bool Location::operator<=(const Location& rhs) const {
    return operator<(rhs) || operator==(rhs);
}

bool Location::operator>(const Location& rhs) const {
    return !operator<=(rhs);
}

bool Location::operator>=(const Location& rhs) const {
    return !operator<(rhs);
}

std::ostream& operator<<(std::ostream& os, const Location& location) {
    // Only stream out _filename and "line" if _filename doesn't match last_filename
    if (location._filename != Location::last_filename) {
        os << location._filename << " line ";
        Location::last_filename = location._filename; // Update last_filename
    }
    os << location._line;
    return os;
}

void Location::next_word() {
    last_filename = ""; // Set last_filename to an empty string
}

