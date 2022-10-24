#include <iostream>
#include <string>
using namespace std;
#pragma  once

class Envio{
  private:
  string nombreD, direccionD, ciudadD, estadoD, nombreR, direccionR, ciudadR, estadoR;
  int postalD, postalR, cuentaEnvios;
  double costoEst;
  
  public:
  Envio();
  Envio(string, string, string, string,string, string, string, string, int, int, double);
  ~Envio();

  
  string getNombreD();
  string getDireccionD();
  string getCiudadD();
  string getEstadoD();
  string getNombreR();
  string getDireccionR();
  string getCiudadR();
  string getEstadoR();
  int getCuentaEnvios();

  int getPostalD();
  int getPostalR();
  double getCostoEst();

  void setNombreD(string);
  void setDireccionD(string);
  void setCiudadD(string);
  void setEstadoD(string);
  void setNombreR(string);
  void setDireccionR(string);
  void setCiudadR(string);
  void setEstadoR(string);
  void setCuentaEnvios(int);
  void setPostalD(int);
  void setPostalR(int);
  void setCostoEst(double);

  void iniciarEnvio();
  virtual double calculaCosto();
  virtual void imprimir();
  void llenarEnvio();
};