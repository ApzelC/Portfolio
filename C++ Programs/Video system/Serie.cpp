#include <iostream>
#include <string>
#include "Serie.h"
#include <sstream>
#include <fstream>
#define ARCHIVO "series.csv"
using namespace std;

Serie::Serie(){

}

Serie::Serie(string nombre, string genero, int id, int duracion, double calificacion,string tituloEp, int episodio, int temporada):Video(nombre, genero, id ,duracion, calificacion){
  this -> tituloEp = tituloEp;
   this -> episodio = episodio;
   this -> temporada = temporada;
}

Serie::~Serie(){
  }

string Serie::getTituloEp(){
  return tituloEp;
}
int Serie::getEpisodio(){
  return episodio;
}
int Serie::getTemporada(){
  return temporada;
}

void Serie::setTituloEp(string tituloEp){
  this-> tituloEp = tituloEp;
}

void Serie::setEpisodio(int episodio){
  this -> episodio = episodio;
}
void Serie::setTemporada(int temporada){
  this -> temporada = temporada;
}

void Serie::imprimir(){
  char delimitador = ',';
  string linea;
  int i = 1;
  ifstream seriesF(ARCHIVO);
  getline(seriesF, linea);
  cout<<"/--------SERIES--------/"<<endl;

  while(getline(seriesF, linea)){
    stringstream stream(linea);
    string nombre, genero, id, duracion, tituloEp, episodio, temporada, calificacion;
    getline(stream, nombre, delimitador);
    getline(stream, genero, delimitador);
    getline(stream, id, delimitador);
    getline(stream, duracion, delimitador);
    getline(stream, tituloEp, delimitador);
    getline(stream, episodio, delimitador);
    getline(stream, temporada, delimitador);
    getline(stream, calificacion, delimitador);
    //convertir a 
    Serie *se = new Serie("", "", 0,  0, 0, "", 0,0);
    
  
     if (nombre ==" x"){
       cout<<"====EPISODIO "<<episodio<< "===="<<endl;
    cout<<"***Número de video: "<<i<<endl;
    cout<<"Titulo del episodio:"<< tituloEp<<endl;
    cout <<"Número de episodio:"<< episodio<<endl;
    cout <<"Temporada:"<<temporada<<endl;
    cout <<"Calificacion: "<< calificacion<< endl;
       
    }
    else if(nombre !=" x"){
    cout<<"========================"<<endl;
    cout<<"***Número de video: "<<i<<endl;
    cout<<"Nombre:"<<nombre<<endl;
    cout<<"Género:"<<genero<<endl;
    cout<<"ID:"<<id<<endl;
    cout<<"Duración:"<<duracion<<endl;
    cout <<"Temporada:"<<temporada<<endl;
    cout <<"Calificacion: "<< calificacion<< endl;
    
      }
    i++;
  }
  
 seriesF.close();
}

ostream& operator<<(ostream& llenar, Serie& a){

  if(a.getNombre()==" x"){
    llenar<<"Título de episodio: "<<a.getTituloEp()<<endl<<"Episodio: "<<a.getEpisodio()<<endl<<"Temporada: "<<a.getTemporada() <<endl<<"Calificación: "<<a.getCalificacion()<< endl<<endl;
  }
  else if(a.getNombre() != " x"){
 llenar <<"Nombre: " << a.getNombre()<< endl << "Género: " <<a.getGenero()<<endl<<"ID: " << a.getId() << endl<< "Duración: "<<a.getDuracion()<<endl <<"Calificación: "<<a.getCalificacion()<<endl;
  }
  return llenar;
  }

//calcular calificacion