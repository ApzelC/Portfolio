#include "Fecha.h"
#include "Bitacora.h"
#include <iostream>
#include <fstream>
#include <sstream>
#include <string>
#include <vector>
using namespace std;

Bitacora::Bitacora(){
  fecha.setMes(" ");
  fecha.setDia(" ");
  fecha.setHora(" ");
  ip = " ";
  razon = " ";
  repetido = "R";
  duplicados = 0;
}
Bitacora::Bitacora(Fecha fecha, string ip, string razon){
  this -> fecha = fecha ;
  this -> ip = ip;
  this -> razon = razon;
}
Bitacora::Bitacora(Fecha fecha, string ip, string razon, string repetido){
  this -> fecha = fecha ;
  this -> ip = ip;
  this -> razon = razon;
  this -> repetido = repetido;
}
Bitacora::~Bitacora(){
}
int Bitacora::getDuplicados(){
  return duplicados;
}
string Bitacora::getIp(){
  return ip;
}
string Bitacora::getRazon(){
  return razon;
}
string Bitacora::getRepetido(){
  return repetido;
}
Fecha Bitacora::getFecha(){
  return fecha;
}
void Bitacora::setDuplicados(int duplicados){
  this -> duplicados = duplicados;
}
void Bitacora::setIp(string ip){
  this -> ip = ip;
}
void Bitacora::setRazon(string razon){
  this -> razon = razon;
}
void Bitacora::setRepetido(string repetido){
  this -> repetido = repetido;
}
void Bitacora::setFecha(Fecha fecha){
   this -> fecha = fecha;
}

void Bitacora::llenarBitacora(vector <Bitacora*> &bita){
  char delimitador = ' ';
  string bit = "bitacora.txt";
  ifstream archivo(bit.c_str());
  string linea, mes, dia, hora, ip, razon, repetido;
  if(!archivo){
    cout<<"No hay archivo, verifíquelo e intente nuevamente"<<endl;
  }
  else{ 
    while (getline(archivo, linea)) {
      stringstream stream(linea);
      getline(stream, mes, delimitador);
      getline(stream, dia, delimitador);
      getline(stream, hora, delimitador);
      getline(stream, ip, delimitador);
      getline(stream, razon, '\n');
      getline(stream, repetido, delimitador);
      Bitacora *bi = new Bitacora(Fecha(mes,dia,hora), ip, razon, repetido);
      bita.push_back(bi);
    }
  }
}
