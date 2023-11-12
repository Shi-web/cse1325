#ifndef TIME_H
#define TIME_H

#include <iostream>

class Time {
private:
    int _hour;
    int _minute;
    int _second;

    // Helper method to rationalize the time values
    void rationalize();

public:
    // Constructors
    Time(int hour, int minute, int second);
    Time(); // Default constructor

    // Overloaded addition operator
    Time operator+(const Time& other) const;

    // Overloaded preincrement operator
    Time& operator++();

    // Overloaded postincrement operator
    Time operator++(int);

    // Comparison operators
    bool operator==(const Time& other) const;
    bool operator!=(const Time& other) const;
    bool operator<(const Time& other) const;
    bool operator>(const Time& other) const;
    bool operator<=(const Time& other) const;
    bool operator>=(const Time& other) const;

    // Streaming operators
    friend std::ostream& operator<<(std::ostream& os, const Time& time);
    friend std::istream& operator>>(std::istream& is, Time& time);
};

#endif // TIME_H

