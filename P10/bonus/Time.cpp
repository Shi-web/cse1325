#include "Time.h"
#include <iomanip>

// Helper method to rationalize the time values
void Time::rationalize() {
    _hour = (_hour + _minute / 60) % 24;
    _minute = _minute % 60;
    _second = _second % 60;
}

// Constructor with default values
Time::Time(int hour, int minute, int second) : _hour(hour), _minute(minute), _second(second) {
    rationalize();
}

// Default constructor
Time::Time() : _hour(0), _minute(0), _second(0) {
    rationalize();
}

// Copy constructor
Time::Time(const Time& other) : _hour(other._hour), _minute(other._minute), _second(other._second) {
    rationalize();
}

// Additional constructor for default Time object (00:00:00)
Time::Time(int hour, int minute, int second, bool defaultConstructor)
    : _hour(hour), _minute(minute), _second(second) {
    if (defaultConstructor) {
        rationalize();
    }
}
// Overloaded preincrement operator
Time& Time::operator++() {
    ++_second;
    rationalize();
    return *this;
}
// Overloaded postincrement operator
Time Time::operator++(int) {
    Time temp = *this;
    ++(*this);
    return temp;
}
// Overloaded addition operator for Time + Time
Time Time::operator+(const Time& other) const {
    return Time(_hour + other._hour, _minute + other._minute, _second + other._second);
}

// Overloaded addition operator for Time + int
Time Time::operator+(int seconds) const {
    return Time(_hour, _minute, _second + seconds, false); // Set defaultConstructor to false
}

// Overloaded addition operator for int + Time
Time operator+(int seconds, const Time& time) {
    return time + seconds;
}

// Comparison operators
bool Time::operator==(const Time& other) const {
    return _hour == other._hour && _minute == other._minute && _second == other._second;
}

bool Time::operator!=(const Time& other) const {
    return !(*this == other);
}

bool Time::operator<(const Time& other) const {
    return std::tie(_hour, _minute, _second) < std::tie(other._hour, other._minute, other._second);
}

bool Time::operator>(const Time& other) const {
    return other < *this;
}

bool Time::operator<=(const Time& other) const {
    return !(*this > other);
}

bool Time::operator>=(const Time& other) const {
    return !(*this < other);
}

// Streaming operators
std::ostream& operator<<(std::ostream& os, const Time& time) {
    os << std::setfill('0') << std::setw(2) << time._hour << ":"
       << std::setfill('0') << std::setw(2) << time._minute << ":"
       << std::setfill('0') << std::setw(2) << time._second;
    return os;
}

std::istream& operator>>(std::istream& is, Time& time) {
    char colon1, colon2;
    is >> time._hour >> std::ws >> colon1 >> time._minute >> std::ws >> colon2 >> time._second;
    if (!is || colon1 != ':' || colon2 != ':') {
        // Set the fail bit if the format is invalid
        is.setstate(std::ios::failbit);
    } else {
        // Rationalize the time values
        time.rationalize();
    }
    return is;
}


