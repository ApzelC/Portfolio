#include <iostream>
#include "Limpieza.h"
using namespace std;

Limpieza::Limpieza(){
  shampoo = "shampoo Savile";
  jabon= "jabón Dove";
  pastaD= "pasta dental Colgate";
  desodorante ="desodorante Axe";
}

Limpieza::Limpieza(string s, string j, string p, string d){
  shampoo =s;
  jabon=j;
  pastaD=p;
  desodorante = d; 
}

Limpieza::~Limpieza(){
}

string Limpieza::getShampoo(){
  return shampoo;
}

string Limpieza::getJabon(){
  return jabon;
}

string Limpieza::getPastaD(){
  return pastaD;
}

string Limpieza::getDesodorante(){
  return desodorante;
}

void Limpieza::setShampoo(string s){
  s = shampoo;
}
void Limpieza::setJabon(string j){
  j = jabon;
}
void Limpieza::setPastaD(string p){
  p = pastaD;
}
void Limpieza::setDesodorante(string d){
  d=desodorante;
}
void Limpieza::imprimirLimpieza(){
  cout<<shampoo<<endl;
  cout<<jabon<<endl;
  cout<<pastaD<<endl;
  cout<<desodorante<<endl;

}

