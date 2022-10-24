#include <iostream>
#include "Juguete.h"
using namespace std;

Juguete::Juguete(){
  carrito="Hot wheels";
  muñeca="Barbie";
  pelota="Balón de futbol";
  peluche="Oso de peluche";
}
Juguete::Juguete(string c, string m, string p, string pe){
  carrito= c;
  muñeca= m;
  pelota= p;
  peluche= pe;
    
}

Juguete::~Juguete(){
}

//getters
string Juguete::getCarrito(){
  return carrito;
}
string Juguete::getMuñeca(){
  return muñeca;
}
string Juguete::getPelota(){
  return pelota;
}
string Juguete::getPeluche(){
  return peluche;
}

//setters
void Juguete::setCarrito(string c){
  c= carrito;
}
void Juguete::setMuñeca(string m){
  m = muñeca;
}
void Juguete::setPelota(string p){
  p= pelota;
}
void Juguete::setPeluche(string pe){
  pe=peluche;
}
void Juguete::imprimirJuguete(){
  cout<<carrito<<endl;
  cout<<muñeca<<endl;
  cout<<pelota<<endl;
  cout<<peluche<<endl;

}