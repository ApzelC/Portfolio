#include <iostream>
#include <string>
using namespace std;
#include "Envio.h"
#pragma  once

class Sobre: public Envio{
  private:
  
  int largo, ancho, add;

  public:
  Sobre();
  Sobre(string, string, string, string, string, string, string, string, int, int, double, int, int, int);
  ~Sobre();
  
  int getLargo();
  int getAncho();
  int getAdd();

  void setLargo(int);
  void setAncho(int);
  void setAdd(int);

  double calculaCosto();
  void imprimir();
  void llenarSobre();
};