#include <iostream>
#include "Comida.h"
using namespace std;

Comida::Comida(){
  manzana= "Manzana Roja";
  carne ="Carne de Res";
  galletas = "Galletas Oreo";
  pan ="Dona";
}

Comida::Comida(string m, string c, string g, string p){
 manzana= m;
 carne =c;
 galletas = g;
 pan = p;
 
}

Comida::~Comida(){  
}

string Comida::getManzana(){
  return manzana;
}
string Comida::getCarne(){
  return carne;
}
string Comida::getGalletas(){
  return galletas;
}
string Comida::getPan(){
  return pan;
}


void Comida::setPan(string p){ 
  p = pan;
  
}
void Comida::setManzana(string m){ 
  m = manzana;
  
}
void Comida::setGalletas(string g){ 
  g = galletas;
  
}
void Comida::setCarne(string c){ 
  c = carne;
  
}

void Comida::imprimirComida(){

  cout<< manzana<< endl;
  cout<< carne<< endl;
  cout<< galletas<< endl;
  cout<< pan << endl;
}