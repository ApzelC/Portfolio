#include <iostream>
#include <string>
using namespace std;
#include "Video.h"

Video::Video(){
  
}
Video::Video(string nombre, string genero, int id, int duracion, double calificacion){
  this -> nombre = nombre;
  this ->genero = genero;
  this -> id = id;
  this -> duracion = duracion;
  this -> calificacion = calificacion;
}

Video::~Video(){
}

string Video::getNombre(){
  return nombre;
}

string Video::getGenero(){
  return genero;
}
int Video::getId(){
  return id;
}

int Video::getDuracion(){
  return duracion;
}
double Video::getCalificacion(){
  return calificacion;
}

void Video::setNombre(string nombre){
  this -> nombre = nombre;
}
void Video::setGenero(string genero){
  this -> genero = genero;
}
void Video::setId(int id){
  this -> id = id;
}
void Video::setDuracion(int duracion){
  this -> duracion = duracion;
}

void Video::setCalificacion(double calificacion){
  this -> calificacion = calificacion;
}

void Video::imprimir(){
}  

int Video::getTemporada(){
  return 0;
}
int Video::getEpisodio(){
  return 0;
}
string Video::getTituloEp(){
  return "";
}