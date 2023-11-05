#include "Circle.h"
#include <cmath>

Circle::Circle(double radius): _radius(radius) {}

std::string Circle::name() const{
	return "Circle (Radius: "+ std::to_string(_radius) + ")";
}

double Circle::area() const{
	return M_PI * _radius * _radius;
}
