#include <iostream>
#include <string>
using namespace std;
#include "Sobre.h"
#include "Envio.h"

Sobre::Sobre(){
  largo = 0;
  ancho = 0;
  add = 0;
  llenarSobre();
}

Sobre::Sobre(string nombreD, string direccionD, string ciudadD, string estadoD, string nombreR, string direccionR, string ciudadR, string estadoR,int postalD, int postalR, double costoEst, int largo, int ancho, int add): Envio(){
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
  this -> add = add;

}


Sobre::~Sobre(){
  
}

int Sobre::getLargo(){
  return largo;
}

int Sobre::getAncho(){
  return ancho;
}

int Sobre:: getAdd(){
  return add;
}



void Sobre::setLargo(int largo){
  this -> largo = largo;
}

void Sobre::setAncho(int ancho){
  this -> ancho = ancho;
}


void Sobre::setAdd(int add){
  this -> add = add;
}
double Sobre::calculaCosto(){
  double precio = getCostoEst() ;
  int final = 0;
  if (getLargo() >25){ 
    final = precio + add;
    }
  else if(getAncho()>30){ 
    final = precio + add;
    }
  else
    final = precio;
  return final;
}

void Sobre::imprimir(){
  cout<<endl<< "El costo del sobre es: "<<calculaCosto()<<endl;
  cout<< "Postal del remitente: "<<getPostalR()<<endl;
  cout<<"Postal del destinatario: "<<getPostalD()<<endl;
  cout <<"Dirección del destinatario: "<<getDireccionD()<<", "<<getCiudadD()<<", "<<getEstadoD()<<"."<<endl;
  cout <<"Dirección del remitente: "<<getDireccionR()<<", "<<getCiudadR()<<", "<<getEstadoR()<<"."<<endl;
}

void Sobre::llenarSobre(){
  llenarEnvio();
  cout<< "largo[cm]: ";
  cin>> largo;
  cout <<"ancho[cm]: ";
  cin>> ancho;
  cout << "Precio extra: ";
  cin>> add;
}