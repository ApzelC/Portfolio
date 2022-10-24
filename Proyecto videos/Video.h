#pragma once 

#include <iostream>
#include <string>
using namespace std;

//CLASE ABSTRACTA 

class Video{
  private:
    string nombre, genero;
    int id, duracion;
    double calificacion;

  public:
  Video();
  Video(string, string, int, int, double);
  ~Video();

  //getters
  string getNombre();
  string getGenero();
  int getId();
  int getDuracion();
  double getCalificacion();

  //setters
  void setNombre(string);
  void setGenero(string);
  void setId(int);
  void setDuracion(int);
  void setCalificacion(double);

  virtual void imprimir();
  virtual string getTituloEp();
  virtual int getEpisodio();
  virtual int getTemporada();
  };
