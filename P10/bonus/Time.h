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
    Time(const Time& other); // Copy constructor

    // Additional constructor for default Time object (00:00:00)
    Time(int hour, int minute, int second, bool defaultConstructor);

    // Overloaded addition operator for Time + Time
    Time operator+(const Time& other) const;

    // Overloaded addition operators for Time + int and int + Time
    Time operator+(int seconds) const;
    friend Time operator+(int seconds, const Time& time);

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

