#include <iostream>
#include <string>
using namespace std;
#include "Paquete.h"
#include "Envio.h"

Paquete::Paquete(){
  largo = 0;
  ancho = 0;
  profundidad = 0;
  peso = 0;
  costoKg = 0.0;
  llenarPaquete();
}

Paquete::Paquete(string nombreD, string direccionD, string ciudadD, string estadoD, string nombreR, string direccionR, string ciudadR, string estadoR, int postalD, int postalR, double costoEst, int largo, int ancho, int profundidad,int peso, double costoKg): Envio(){
  setNombreD(nombreD);
  setDireccionD(direccionD);
  setCiudadD(ciudadD);
  setEstadoD(estadoD);
  setNombreR(nombreR);
  setDireccionR(direccionR);
  setCiudadR(ciudadR);
  setEstadoR(estadoR);
  setPostalD(postalD);
  setPostalR(postalR);
  setCostoEst(costoEst);

  this -> largo = largo;
  this -> ancho = ancho;
  this -> profundidad = profundidad;
  this -> peso = peso;
  this -> costoKg = costoKg;
  
}


Paquete::~Paquete(){
  
}

int Paquete::getLargo(){
  return largo;
}

int Paquete::getAncho(){
  return ancho;
}

int Paquete::getProfundidad(){
  return profundidad;
}

int Paquete::getPeso(){
  return peso;
}

double Paquete::getCostoKg(){
  return costoKg;
}

void Paquete::setLargo(int largo){
  this -> largo = largo;
}

void Paquete::setAncho(int ancho){
  this -> ancho = ancho;
}

void Paquete::setProfundidad(int profundidad){
  this -> profundidad = profundidad;
}

void Paquete::setPeso(int peso){
  this -> peso = peso;
}

void Paquete::setCostoKg(double costoKg){
  this ->costoKg = costoKg;
}

double Paquete::calculaCosto(){
double precio = (peso* costoKg) + getCostoEst() ;
  return precio;
}

void Paquete::imprimir(){

  cout<<endl<< "El costo del paquete es: "<< calculaCosto()<<" pesos"<<endl;
  cout<< "Postal del remitente: "<<getPostalR()<<endl;
  cout<<"Postal del destinatario: "<<getPostalD()<<endl;
  cout <<"Dirección del remitente: "<<getDireccionR()<<", "<<getCiudadR()<<", "<<getEstadoR()<<"."<<endl;
  cout <<"Dirección del destinatario: "<<getDireccionD()<<", "<<getCiudadD()<<", "<<getEstadoD()<<"."<<endl;
}

void Paquete::llenarPaquete(){
  llenarEnvio();
  cout<< "largo[cm]: ";
  cin>> largo;
  cout <<"ancho[cm]: ";
  cin>> ancho;
  cout << "Profundidad[cm]: ";
  cin>> profundidad;
  cout <<"peso[Kg]: ";
  cin>> peso;
  cout<< "costoKg[MXN]: ";cin >> costoKg;
}