#include <iostream>
#include <string>
using namespace std;
#include "Envio.h"

const double ESTANDAR = 50;

Envio::Envio(){
  nombreD = "";
  direccionD = "";
  ciudadD = "";
  estadoD = "";
  nombreR = "";
  direccionR = "";
  ciudadR = "";
  estadoR = "";
  postalD = 0;
  postalR = 0;
  costoEst = ESTANDAR;
  cuentaEnvios = 0;
}

Envio::Envio(string nombreD, string direccionD, string ciudadD, string estadoD, string nombreR, string direccionR, string ciudadR, string estadoR, int postalD, int postalR, double costoEst){
  this -> nombreD =nombreD;
  this -> direccionD = direccionD;
  this -> ciudadD = ciudadD;
  this -> estadoD = estadoD;
  this -> nombreD =nombreR;
  this -> direccionD = direccionR;
  this -> ciudadD = ciudadR;
  this -> estadoD = estadoR;
  
  this ->postalD = postalD;
  this -> postalR = postalR;
  this -> costoEst = costoEst;
}


Envio::~Envio(){
  
}

string Envio::getNombreD(){
  return nombreD;
}

string Envio::getDireccionD(){
  return direccionD;
}

string Envio::getCiudadD(){
  return ciudadD;
}

string Envio::getEstadoD(){
  return estadoD;
}

string Envio::getNombreR(){
  return nombreR;
}

string Envio::getDireccionR(){
  return direccionR;
}

string Envio::getCiudadR(){
  return ciudadR;
}

string Envio::getEstadoR(){
  return estadoR;
}

int Envio:: getPostalD(){
 return postalD; 
}

int Envio::getPostalR(){
  return postalR;
}

double Envio::getCostoEst(){
  return costoEst;
}

int Envio::getCuentaEnvios(){
  return cuentaEnvios;
}
void Envio::setNombreD(string nombreD){
  this -> nombreD = nombreD;
}

void Envio::setDireccionD(string direccionD){
  this -> direccionD=direccionD;
}

void Envio::setCiudadD(string ciudadD){
  this -> ciudadD=ciudadD;
}

void Envio::setEstadoD(string estadoD){
  this -> estadoD=estadoD;
}

void Envio::setNombreR(string nombreR){
  this -> nombreR = nombreR;
}

void Envio::setDireccionR(string direccionR){
  this -> direccionR=direccionR;
}

void Envio::setCiudadR(string ciudadR){
  this -> ciudadR=ciudadR;
}

void Envio::setEstadoR(string estadoR){
  this -> estadoR=estadoR;
}
void Envio::setPostalD(int postalD){
  this -> postalD=postalD;
}

void Envio::setPostalR(int postalR){
  this-> postalR = postalR;
}

void Envio::setCostoEst(double costoEst){
  this -> costoEst = costoEst;
}

void Envio::setCuentaEnvios(int cuentaEnvios){
  this -> cuentaEnvios = cuentaEnvios;
}

double Envio::calculaCosto(){
  return 0;  
}

void Envio::llenarEnvio(){
  cout <<"Nombre del destinatario: ";
  cin>> nombreD;
  cout<<"Direccion del destinatario: ";
  cin>> direccionD;
  cout<<"Ciudad del destinatario: ";
  cin>> ciudadD;
  cout<<"Estado del destinatario: ";
  cin>> estadoD;
  cout<<"Postal del destinatario: ";
  cin>>postalD;

  cout <<endl<<"Nombre del remitente: ";
  cin>> nombreR;
  cout<<"Direccion del remitente: ";
  cin>> direccionR;
  cout<<"Ciudad del remitente: ";
  cin>> ciudadR;
  cout<<"Estado del remitente: ";
  cin>> estadoR;
  cout<<"Postal del remitente: ";
  cin>> postalR;
    
}
void Envio::iniciarEnvio(){
  cout<<"-/-/-/BIENVENIDO/-/-/-"<<endl<<endl;
  cout<<"Cuantos envios quiere hacer?: ";
  cin>>cuentaEnvios;
}
void Envio::imprimir(){
}