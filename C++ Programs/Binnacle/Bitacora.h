#pragma once
#include "Fecha.h"
#include <iostream>
#include <string> 
#include <vector>
using namespace std;

class Bitacora{
  private:
    Fecha fecha;
    string ip, razon, repetido;
    int duplicados;
  public:
    Bitacora();
    Bitacora(Fecha, string, string);
    Bitacora(Fecha, string, string, string);
    ~Bitacora();

//getters
  int getDuplicados();
  string getIp();
  string getRazon();
  string getRepetido();
  Fecha getFecha();

//setters
  void setDuplicados(int);
  void setIp(string);
  void setRazon(string);
  void setRepetido(string);
  void setFecha(Fecha);

  void llenarBitacora(vector <Bitacora*> &);
};