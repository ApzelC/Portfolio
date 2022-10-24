#include <iostream>
#include <string>
using namespace std;
#include "Envio.h"
#pragma  once

class Paquete: public Envio{
  private:
  
  int largo, ancho, profundidad, peso;
  double costoKg;

  public:
  Paquete();
  Paquete(string, string, string, string, string, string, string, string, int, int, double, int, int, int,int, double);
  ~Paquete();
  
  int getLargo();
  int getAncho();
  int getProfundidad();
  int getPeso();
  double getCostoKg();

  void setLargo(int);
  void setAncho(int);
  void setProfundidad(int);
  void setPeso(int);
  void setCostoKg(double);

  double calculaCosto();
  void imprimir();
  void llenarPaquete();
};