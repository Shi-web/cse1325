#include "Location.h"

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
    os << location._filename << " line " << location._line;
    return os;
}

