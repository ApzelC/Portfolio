#include <iostream>
#include <string>
#include <sstream>
#include <fstream>
#include "Pelicula.h"
#define ARCHIVO2 "peliculas.csv"

using namespace std;

Pelicula::Pelicula(){
  
}
Pelicula::Pelicula(string nombre, string genero, int id, int duracion, double calificacion):Video(nombre, genero, id ,duracion, calificacion){
  
}

Pelicula::~Pelicula(){
  }

void Pelicula::imprimir(){  
  ifstream PeliF(ARCHIVO2);
  string linea2;
  int i = 16;
  char delimitador = ',';
  getline(PeliF, linea2);
  cout<<"/-----PELICULAS-----/"<<endl;
    while(getline(PeliF, linea2)){
      stringstream stream(linea2);
      string nombre, genero, id, duracion, calificacion;
      getline(stream, nombre, delimitador);
      getline(stream, genero, delimitador);
      getline(stream, id, delimitador);
      getline(stream, duracion, delimitador);
      getline(stream, calificacion, delimitador);
      cout<<"========================"<<endl;
      cout<<"***Número de video: "<<i<<endl;
      cout<<"Nombre:"<<nombre<<endl;
      cout<<"Género:"<<genero<<endl;
      cout<<"ID:"<<id<<endl;
      cout<<"Duración:"<<duracion<<endl;
      cout <<"Calificacion: "<< calificacion<< endl;
      i++;
      }
  PeliF.close();
  }

 ostream& operator<<(ostream& llenar, Pelicula& a){

 llenar <<"Nombre: " << a.getNombre()<< endl << "Género: " <<a.getGenero()<<endl<<"ID: " << a.getId() << endl<< "Duración: "<<a.getDuracion()<<endl <<"Calificación: "<<a.getCalificacion() << endl<<endl;
    return llenar;
  }