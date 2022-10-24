#pragma once
#include <iostream>
#include <string> 
using namespace std;

class Fecha{
  private:
    string mes, dia, hora;
  public:
    Fecha();
    Fecha(string, string, string);
    ~Fecha();

//getters
  string getMes();
  string getDia();
  string getHora();

//setters
  void setMes(string);
  void setDia(string);
  void setHora(string);
};