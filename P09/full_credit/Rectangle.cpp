#include "Rectangle.h"

Rectangle::Rectangle(double width, double height) : _width(width), _height(height){}

std::string Rectangle::name() const{
	return "Rectangle (Width: "+std::to_string(_width) + ", Height: "+ std::to_string(_height)+")";
}

double Rectangle::area() const{
	return _width * _height;

}
