#pragma once 

#include <iostream>
#include <string>
#include "Video.h"
using namespace std;

class Pelicula: public Video{
  private:
      
  public:

  Pelicula();
  Pelicula(string, string, int, int, double);
  ~Pelicula();

  //getters
  
  void imprimir();
  friend ostream& operator<<(ostream &out,Pelicula&);
  };
