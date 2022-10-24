#include "Fecha.h"
#include <iostream>
#include <string>
using namespace std;

Fecha::Fecha(){
  mes = " ";
  dia = " ";
  hora = " ";
}
Fecha::Fecha(string mes, string dia, string hora){
  this -> mes = mes;
  this -> dia = dia;
  this -> hora = hora;
}
Fecha::~Fecha(){
}
//getters
string Fecha::getMes(){
  return mes;
}
string Fecha::getDia(){
  return dia;
}
string Fecha::getHora(){
  return hora;
}
void Fecha::setMes(string mes){
  this -> mes = mes;
}
void Fecha::setDia(string dia){
  this -> dia = dia;
}
void Fecha::setHora(string hora){
  this -> hora = hora;
}