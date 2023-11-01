#ifndef __SHAPE_H
#define __SHAPE_H

#include <string>

class Shape{
public:
	virtual std::string name()const;
	virtual double area() const;
	virtual std::string to_string() const;
	
	
};
#endif
